import { Avatar, Box, Card, CardContent, Grid, Typography } from '@mui/material';
import HandshakeIcon from '@mui/icons-material/Handshake';

export const TotalProfit = (props) => (
  <Card {...props}>
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
            구직 활동
          </Typography>
          <Typography
            color="textPrimary"
            variant="h4"
          >
            {`${props.appCnt}건`}
          </Typography>
        </Grid>
        <Grid item>
          <Avatar
            sx={{
              backgroundColor: 'primary.main',
              height: 56,
              width: 56
            }}
          >
            <HandshakeIcon />
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
          {`총 ${props.appCnt}건의 구직 활동이 진행중입니다.`}
        </Typography>
      </Box>
    </CardContent>
  </Card>
);
