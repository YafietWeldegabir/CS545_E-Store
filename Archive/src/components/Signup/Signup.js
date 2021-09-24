import React, { Fragment,useState } from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import { makeStyles } from '@material-ui/core/styles';
import { Field, Form, Formik } from 'formik';
import { useHistory } from 'react-router-dom';
import cogoToast from 'cogo-toast';
import api from '../../configuration/api';

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
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

const Signup = () => {
  const classes = useStyles();
  const history = useHistory();

  let [isBuyer,setIsBuyer] = useState(false);

  return (
    <Box
      display="flex"
      justifyContent="center"
      alignItems="center"
      style={{
        height: '100vh',
      }}
    >
      <Formik
        initialValues={{ username: '', password: '', fullname: '',  }}
        onSubmit={(values) => {
          let seller = false;
          let buyer = false;
          if (!isBuyer) {
            seller = true;
          }
          else{
            buyer = true;
          }
          api
            .post('register', {
              username: values.username,
              password: values.password,
              fullName: values.fullname,
              seller: seller,
              buyer: buyer,
              city: values.city,
              zipCode: values.zipCode,
              country: values.country,
              state: values.state
            })
            .then(function (response) {
              cogoToast.success('You have successfully registerd!');
              history.push('/');
            });
        }}
      >
        {({ isSubmitting }) => (
          <Form>
            <Grid style={{width:"500px"}} container spacing={2}>
              <Grid item xs={12}>
                <Field name="fullname">
                  {({ field, form, meta }) => (
                    <TextField
                      autoComplete="fname"
                      label="Fullname"
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
              {isBuyer?
                  <Fragment>
                      <Grid item xs={12}>
                        <Field name="state">
                          {({ field, form, meta }) => (
                            <TextField
                              autoComplete="state"
                              label="State"
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
                        <Field name="city">
                          {({ field, form, meta }) => (
                            <TextField
                              autoComplete="city"
                              label="City"
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
                        <Field name="zipCode">
                          {({ field, form, meta }) => (
                            <TextField
                              autoComplete="Zip Code"
                              label="Zip Code"
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
                        <Field name="country">
                          {({ field, form, meta }) => (
                            <TextField
                              autoComplete="state"
                              label="Country"
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
                    </Fragment>:<div/>}
              <Grid item xs={12}>
                <label>
                  <Field type="radio" name="picked" value="buyer" checked={isBuyer} onChange={(e)=>{
                    setIsBuyer(true);
                  }} />
                  Buyer
                </label>
                <label>
                  <Field type="radio" name="picked" value="seller" checked={!isBuyer}  onChange={(e)=>{
                    setIsBuyer(false);
                  }}/>
                  Seller
                </label>
              </Grid>
            </Grid>
            <Grid container justify="flex-end">
            <Button
              type="submit"
              variant="contained"
              color="primary"
              className={classes.submit}
            >
              Sign Up
            </Button>
            </Grid>
            <Grid container justify="flex-end">
              <Grid item>
                <Link href="/login" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </Form>
        )}
      </Formik>
    </Box>
  );
};

export default Signup;
