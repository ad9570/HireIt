import { format } from 'date-fns';
import PerfectScrollbar from 'react-perfect-scrollbar'

import {
  Box,
  Button,
  Card,
  CardHeader,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow
} from '@mui/material';
import ArrowRightIcon from '@mui/icons-material/ArrowRight';
import { SeverityPill } from '../SeverityPill';

export const LatestOrders = (props) => (
  <Card {...props}>
    <CardHeader title="회원 리스트" />
    <PerfectScrollbar>
      <Box sx={{ minWidth: 800 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>
                ID
              </TableCell>
              <TableCell>
                NAME
              </TableCell>
              <TableCell>
                NICKNAME
              </TableCell>
              <TableCell>
                ROLE
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {props.userList && props.userList.map((list) => (
              <TableRow
                hover
                key={list.user_id}
              >
                <TableCell>
                  {list.username}
                </TableCell>
                <TableCell>
                  {list.name}
                </TableCell>
                <TableCell>
                {list.nickname}
                </TableCell>
                <TableCell>
                  <SeverityPill
                    color={(list.role === '0' && 'error')
                    || (list.role === '1' && 'success')
                    || 'info'}
                  >
                    {list.role === '0' ? '관리자' : list.role === '1' ? '개인회원' : '기업회원'}
                  </SeverityPill>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Box>
    </PerfectScrollbar>
    <Box
      sx={{
        display: 'flex',
        justifyContent: 'flex-end',
        p: 2
      }}
    >
      <Button
        color="primary"
        endIcon={<ArrowRightIcon fontSize="small" />}
        size="small"
        variant="text"
      >
        View all
      </Button>
    </Box>
  </Card>
);
