import { Box, Container, Grid } from '@mui/material';
import { Budget } from '../components/dashboard/Budget';
import { LatestOrders } from '../components/dashboard/LatestOrders';
import { LatestProducts } from '../components/dashboard/LatestProducts';
import { TasksProgress } from '../components/dashboard/TasksProgress';
import { TotalCustomers } from '../components/dashboard/TotalCustomers';
import { TotalProfit } from '../components/dashboard/TotalProfit';
import { DashboardLayout } from '../components/DashboardLayout';

const Dashboard = ({ statistics, userList, applyList, applyHandle }) => (
  <>
      <title>
        Dashboard | Material Kit
      </title>
    
    <Box
      component="main"
      sx={{
        flexGrow: 1,
        py: 8
      }}
    >
      <Container maxWidth={false}>
        <Grid
          container
          spacing={3}
        >
          <Grid
            item
            lg={3}
            sm={6}
            xl={3}
            xs={12}
          >
            <TotalCustomers indCnt={statistics.indiv} crpCnt={statistics.corp}/>
          </Grid>
          <Grid
            item
            xl={3}
            lg={3}
            sm={6}
            xs={12}
          >
            <Budget jobPostCnt={statistics.jobPosting}/>
          </Grid>
          <Grid
            item
            xl={3}
            lg={3}
            sm={6}
            xs={12}
          >
            <TotalProfit appCnt={statistics.apply}/>
          </Grid>
          <Grid
            item
            xl={3}
            lg={3}
            sm={6}
            xs={12}
          >
            <TasksProgress hireRate={statistics.rate}/>
          </Grid>
          <Grid
            item
            lg={8}
            md={12}
            xl={9}
            xs={12}
          >
            
          </Grid>
          <Grid
            item
            lg={12}
            md={12}
            xl={12}
            xs={12}
          >
          </Grid>
          <Grid
            item
            lg={4}
            md={6}
            xl={3}
            xs={12}
          >
            <LatestProducts applyList={applyList} applyHandle={applyHandle}/>
          </Grid>
          <Grid
            item
            lg={8}
            md={12}
            xl={9}
            xs={12}
          >
            <LatestOrders userList={userList}/>
          </Grid>
        </Grid>
      </Container>
    </Box>
  </>
);

Dashboard.getLayout = (page) => (
  <DashboardLayout>
    {page}
  </DashboardLayout>
);

export default Dashboard;
