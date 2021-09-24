import React from 'react';
import { useDispatch } from 'react-redux';
import { Field, Form, Formik } from 'formik';
import { login } from '../../store/user';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import { makeStyles } from '@material-ui/core/styles';
import { Box, Card, CardContent } from '@material-ui/core';
import { Link, useHistory } from 'react-router-dom';
import cogoToast from 'cogo-toast';

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

const LoginComponent = () => {
  const dispatch = useDispatch();
  const classes = useStyles();
  const history = useHistory();
  return (
    <Box
      display="flex"
      justifyContent="center"
      alignItems="center"
      style={{
        height: '100vh',
      }}
    >
      <Card>
        <CardContent>
          <Formik
            initialValues={{ username: '', password: '' }}
            onSubmit={(values) => {
              dispatch(login(values)).then(() => {
                cogoToast.success('Login Successful!');
                // history.push('/');
                window.location.reload(true);
              });
            }}
          >
            <Form>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <Field name="username">
                    {({ field, form, meta }) => (
                      <TextField
                        autoComplete="username"
                        label="Username"
                        variant="outlined"
                        required
                        fullWidth
                        autoFocus
                        {...field}
                        type="text"
                      />
                    )}
                  </Field>
                </Grid>
                <Grid item xs={12}>
                  <Field name="password">
                    {({ field, form, meta }) => (
                      <TextField
                        autoComplete="password"
                        label="Password"
                        variant="outlined"
                        required
                        fullWidth
                        autoFocus
                        {...field}
                        type="password"
                      />
                    )}
                  </Field>
                </Grid>

                <Grid container item xs={12} justify="flex-end">
                  <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    className={classes.submit}
                  >
                    Login
                  </Button>
                </Grid>
              </Grid>
            <Grid container justify="flex-end">
              <Grid item>
                <Link to="/" variant="body2">
                  Go back to home
                </Link>
              </Grid>
            </Grid>
            </Form>
          </Formik>
        </CardContent>
      </Card>
    </Box>
  );
};

export default LoginComponent;
