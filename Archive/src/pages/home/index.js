import React, { useEffect } from 'react';

import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { Route, Switch, useHistory } from 'react-router-dom';
import Products from '../../containers/Products/Products';
import { authenticationService } from '../../services/authentication.service';
import { Role } from '../../helpers/role';
import Orders from '../buyer/orders';
import Sellers from '../buyer/sellers';
import { AppBar, Button, Chip, Avatar, Box } from '@material-ui/core';
import Container from '@material-ui/core/Container';
import ProductPage from '../common/product-page';

const useStyles = makeStyles((theme) => ({
  icon: {
    marginRight: theme.spacing(2),
  },
  heroContent: {
    backgroundColor: theme.palette.background.paper,
    padding: theme.spacing(8, 0, 6),
  },
  heroButtons: {
    marginTop: theme.spacing(4),
  },
  cardGrid: {
    paddingTop: theme.spacing(8),
    paddingBottom: theme.spacing(8),
  },
  link: {
    zIndex: 'right',
    justify: 'space-between',
    margin: theme.spacing(1, 1.5),
    float: 'left',
  },
  card: {
    height: '100%',
    display: 'flex',
    flexDirection: 'column',
  },
  cardMedia: {
    paddingTop: '56.25%', // 16:9
  },
  cardContent: {
    flexGrow: 1,
  },
  footer: {
    backgroundColor: theme.palette.background.paper,
    padding: theme.spacing(6),
  },
}));

const navStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function Home() {
  const classes = useStyles();
  const nav_bar = navStyles();
  const history = useHistory();

  useEffect(() => {
    if (authenticationService.currentUserValue) {
      if (authenticationService.currentUserValue.role === Role.Admin) {
        history.push('/admin');
      }
      if (authenticationService.currentUserValue.role === Role.Seller) {
        history.push('/seller');
      }
    }
  }, [history]);

  const redirectToSignup = () => {
    history.push('/register');
  };
  const redirectToLogin = () => {
    history.push('/login');
  };

  return (
    <>
      <CssBaseline />
     
        <Toolbar>
          <Typography
            variant="h6"
            className={nav_bar.title}
            onClick={() => {
              history.push('/');
            }}
          >
            MIU-SHOP
          </Typography>
          </Toolbar>
          
          {authenticationService.currentUserValue && (
            <>
              <Button
                color="inherit"
                onClick={() => {
                  history.push('/buyer/orders');
                }}
              >
                Your Orders
              </Button>

              <Button
                color="inherit"
                onClick={() => {
                  history.push('/buyer/sellers');
                }}
              >
                Follow Sellers
              </Button>
              <Chip
                avatar={<Avatar></Avatar>}
                label={
                  authenticationService.currentUserValue &&
                  authenticationService.currentUserValue.username
                }
                color="primary"
              />
              <Button
                color="inherit"
                onClick={() => {
                  authenticationService.logout();
                  history.push('/');
                }}
              >
                Logout
              </Button>
            </>
          )}

          {!authenticationService.currentUserValue && (
            <div>
              <Button
                onClick={redirectToLogin}
                color="inherit"
                variant="outlined"
                className={classes.link}
              >
                Login
              </Button>
              <Button
                onClick={redirectToSignup}
                color="inherit"
                variant="outlined"
                className={classes.link}
              >
                Sign Up
              </Button>
            </div>
          )}
        
      

      <Switch>
        <Route path="/buyer/orders" component={Orders} />
        <Route path="/buyer/sellers" component={Sellers} />
        <Route path="/buyer/products/:id" component={ProductPage} />
        <Route path="/">
          <Box component="span" m={1}>
            <Container maxWidth="md">
              <Products />
            </Container>
          </Box>
        </Route>
      </Switch>
    </>
  );
}
