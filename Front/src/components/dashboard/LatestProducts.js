import {
    Box,
    Button,
    Card,
    CardHeader,
    Divider,
    IconButton,
    List,
    ListItem,
    ListItemText
    } from '@mui/material';
    import ArrowRightIcon from '@mui/icons-material/ArrowRight';
    import CheckCircleIcon from '@mui/icons-material/CheckCircle';

    export const LatestProducts = (props) => (
    <Card {...props}>
        <CardHeader
        subtitle={`${props.applyList.length} in total`}
        title="기업회원 신청 리스트"
        />
        <Divider />
        <List>
        {props.applyList && props.applyList.map((list, idx) => (
            <ListItem
            divider={idx < props.applyList.length - 1}
            key={list.num}
            >
            <ListItemText
                primary={list.title}
                secondary={list.content}
            />
            <IconButton
                edge="end"
                size="small"
                onClick={() => props.applyHandle(list.num, list.corp_idx, list.title)}
            >
                <CheckCircleIcon />
            </IconButton>
            </ListItem>
        ))}
        </List>
        <Divider />
        <Box
        sx={{
            display: 'flex',
            justifyContent: 'flex-end',
            p: 2
        }}
        >
        <Button
            color="primary"
            endIcon={<ArrowRightIcon />}
            size="small"
            variant="text"
        >
            View all
        </Button>
        </Box>
    </Card>
    );
