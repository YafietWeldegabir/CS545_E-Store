import { Container, Grid, makeStyles } from '@material-ui/core';
import MUIDataTable from 'mui-datatables';
import React, { useEffect, useState } from 'react';
import api from '../../configuration/api';
import { authenticationService } from '../../services/authentication.service';

const useStyles = makeStyles((theme) => ({
  container: {
    paddingTop: theme.spacing(4),
    paddingBottom: theme.spacing(4),
  },
}));

const Sellers = () => {
  useEffect(getAllSeller, []);
  const [sellers, setSellers] = useState([]);
  const [followUsers, setFollowUsers] = useState([]);
  const [userId, setUserId] = useState(null);
  const classes = useStyles();

  useEffect(()=>{
    setUserId(
      authenticationService.currentUserValue.userId
    );
  })

  function getAllSeller() {
    api
      .get('sellers/')
      .then(function (response) {
      console.log(response);
      setSellers(response.data);      })
      .catch(function (error) {
        console.log(error);
      });
  }


  function followSeller(sellerId) {
    api
      .post('/buyers/'+userId+'/sellers/'+sellerId+'/follow')
      .then(function (response) {
        setFollowUsers([...followUsers, sellerId]);  
      }).catch(function (error) {
        console.log(error);
      });
  }

  const options = {
    selectableRows: true,
    selectableRowsOnClick: true,
    onRowClick: handleRowClick,
  };
  function handleRowClick() {
    console.log('Row clicked');
  }


  useEffect(getAllSeller, []);

  useEffect(getAllSeller, []);

  const columns = [
    {
      name:"id"
    },
    {
      name: 'fullName',
    },
    {
      name: 'Actions',
      options: {
        filter: false,
        sort: false,
        empty: true,
        customBodyRender: (value, tableMeta, updateValue) => {
          return (
            <>
              <button
                onClick={() => {
                  if(followUsers.includes(tableMeta.rowData[0])){
                    setFollowUsers( followUsers.filter(e=>e!==tableMeta.rowData[0]));

                  }else{

                    followSeller(tableMeta.rowData[0])
                  }
                }}
              >

                {followUsers.includes(tableMeta.rowData[0])? 'unfollow': 'Follow'} 

              </button>
            </>
          );
        },
      },
    },
  ];
  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        <Grid item xs={12} md={12} lg={12}>
          <MUIDataTable
            title={'Sellers You followed'}
            data={sellers}
            columns={columns}
            options={options}
          />
        </Grid>
      </Grid>
    </Container>
  );
//   return (<div>
//     {
//     sellers.map(person => (
//     <p>{person.username} </p>
// ))}

// </div>)}

    
  }


export default Sellers;
