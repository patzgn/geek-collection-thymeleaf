import { Box, Container, Paper, Stack, Typography } from '@mui/material';
import Button from '@mui/material/Button';


function Hero({ auth }) {
    return (
        <Box
            sx={{
                bgcolor: 'grey.100',
                py: 8,
            }}
        >

            <Container maxWidth="md">
                <Typography
                    component="h1"
                    variant='h3'
                    // align='center'
                    color="text.primary"
                    fontFamily="Audiowide"
                    gutterBottom
                >
                    GeekCollection
                </Typography>
                <Typography
                    component="h2"
                    variant="h4"
                    color="text.secondary"
                >
                    Track your geek collection
                </Typography>
                <Typography
                    variant='h6'
                    color="text.secondary"
                >
                    <ul>
                        <li>Catalog your games and books collection</li>
                        <li>Create wishlists</li>
                        <li>Take part in reading challenge</li>
                        <li>Check most popular games and books among users</li>
                    </ul>
                </Typography>
                <Stack
                    direction="row"
                    spacing={2}
                >
                    {!auth && (
                        <Button
                            variant="contained"
                            size="large"
                            sx={{
                                ml: 4,
                                fontSize: '20px',
                            }}
                        >
                            Sign In
                        </Button>
                    )}
                    {auth &&
                        <>
                            <Button
                                variant="contained"
                                size="large"
                                sx={{
                                    ml: 4,
                                    fontSize: '20px',
                                }}
                            >
                                My Profile
                            </Button>
                            <Button variant='outlined'>Log out</Button>
                        </>
                    }
                </Stack>
            </Container>
        </Box >
    )
}

export default Hero;


//
// <Container className="px-4 py-5">
//     <h1 class="mb-5 display-6 fw-bold text-center">
//         Track your geek collection
//     </h1>

//     <div class="col-lg-6 mx-auto">
//         <ul class="mb-5">
//             <li>Catalog your games and books collection</li>
//             <li>Create wishlists</li>
//             <li>Take part in reading challenge</li>
//             <li>Check most popular games and books among users</li>
//         </ul>

//         <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
//             <a href="#" class="btn btn-primary btn-lg px-4">Sign in</a>
//             <a href="#" class="btn btn-primary btn-lg px-4">My Profile</a>
//             <a href="#" class="btn btn-outline-secondary btn-lg px-4">Log out</a>
//         </div>
//     </div>
// </Container>