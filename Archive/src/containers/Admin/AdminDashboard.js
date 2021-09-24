import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Sellers from './Sellers/Sellers';
import Reviews from './Reviews/Reviews';
import { Button, Chip, Avatar } from '@material-ui/core';
import { Link, Route, Switch, useHistory } from 'react-router-dom';
import { authenticationService } from '../../services/authentication.service';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
  link: {
    textDecoration: 'none',
    color: 'white',
  },
}));

export default function Dashboard() {
  const history = useHistory();
  const nav_bar = useStyles();

  return (
    <div className={nav_bar.root}>
        <Toolbar>
          <Typography
            variant="h6"
            className={nav_bar.title}
            onClick={() => {
              history.push('/');
            }}
          >
            E-SHOP
          </Typography>

          <Link to="/admin" className={nav_bar.link}>
            <Button >Home</Button>
          </Link>
          <Link to="/admin/reviews" className={nav_bar.link}>
            <Button >Reviews</Button>
          </Link>
          <Link to="/admin/sellers" className={nav_bar.link}>
            <Button >Sellers</Button>
          </Link>
          <Chip avatar={<Avatar></Avatar>} label="Admin"  />
          <Button
            color="inherit"
            onClick={() => {
              authenticationService.logout();
              history.push('/');
            }}
          >
            Logout
          </Button>
        </Toolbar>
      
      <main>
        <Box mt={2}>
          <Switch>
            <Route path="/admin/reviews" component={Reviews} />
            <Route path="/admin/sellers" component={Sellers} />
            <Route path="/">
              <Container maxWidth="lg">
                <Grid container spacing={3}>
                  <Grid item xs={12} md={12} lg={12}>
                    <h1>Welcome to the admin panel</h1>
                  </Grid>
                </Grid>
              </Container>
            </Route>
          </Switch>
        </Box>
      </main>
    </div>
  );
}
