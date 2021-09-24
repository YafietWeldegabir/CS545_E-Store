import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import api from '../../configuration/api';

import { Button, Chip, Avatar } from '@material-ui/core';
import { Link, Route, Switch, useHistory } from 'react-router-dom';
import Products from '../../pages/seller/products';
import Orders from '../../pages/seller/orders';
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

export default function SellerDashboard() {
  const history = useHistory();
  const nav_bar = useStyles();
  const [active, setActive] = useState(false);

  useEffect(getLoggedInSeller, []);

  function getLoggedInSeller() {
    api
      .get(`sellers/ +${authenticationService.currentUserValue.userId}`)
      .then(function (response) {
        setActive(response.data.approved);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  return (
    <div className={nav_bar.root}>
      <AppBar position="static">
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

          {active ? (
            <>
              {' '}
              <Link to="/seller" className={nav_bar.link}>
                <Button color="inherit">Home</Button>
              </Link>
              <Link to="/seller/products" className={nav_bar.link}>
                <Button color="inherit">Products</Button>
              </Link>
              <Chip
                avatar={<Avatar></Avatar>}
                label={
                  authenticationService.currentUserValue &&
                  authenticationService.currentUserValue.username
                }
                color="inherit"
              />
            </>
          ) : (
            ''
          )}
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
      </AppBar>
      {active ? (
        <main>
          <Box mt={2}>
            <Switch>
              <Route exact path="/seller/products" component={Products} />
              <Route path="/seller/orders/:productId" component={Orders} />
              <Route path="/">
                <Container maxWidth="lg">
                  <Grid container spacing={3}>
                    <Grid item xs={12} md={12} lg={12}>
                      <h1>Seller Index</h1>
                    </Grid>
                  </Grid>
                </Container>
              </Route>
            </Switch>
          </Box>
        </main>
      ) : (
        <main>
          <Box mt={2}>
            <Switch>
              <Route path="/">
                <Container maxWidth="lg">
                  <Grid container spacing={3}>
                    <Grid item xs={12} md={12} lg={12}>
                      <h1>Account is not active</h1>
                    </Grid>
                  </Grid>
                </Container>
              </Route>
            </Switch>
          </Box>
        </main>
      )}
    </div>
  );
}
