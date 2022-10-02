import { Avatar, Box, Card, CardContent, Grid, Typography } from '@mui/material';
import PostAddIcon from '@mui/icons-material/PostAdd';

export const Budget = (props) => (
  <Card
    sx={{ height: '100%' }}
    {...props}
  >
    <CardContent>
      <Grid
        container
        spacing={3}
        sx={{ justifyContent: 'space-between' }}
      >
        <Grid item>
          <Typography
            color="textSecondary"
            gutterBottom
            variant="overline"
          >
            채용 공고
          </Typography>
          <Typography
            color="textPrimary"
            variant="h4"
          >
            {`${props.jobPostCnt}건`}
          </Typography>
        </Grid>
        <Grid item>
          <Avatar
            sx={{
              backgroundColor: 'error.main',
              height: 56,
              width: 56
            }}
          >
            <PostAddIcon />
          </Avatar>
        </Grid>
      </Grid>
      <Box
        sx={{
          pt: 2,
          display: 'flex',
          alignItems: 'center'
        }}
      >
        <Typography
          color="textSecondary"
          variant="caption"
        >
          {`총 ${props.jobPostCnt}건의 채용 공고가 있습니다.`}
        </Typography>
      </Box>
    </CardContent>
  </Card>
);
