import * as React from 'react';
import Header from "./Header";
import GameTable from "./games/GameTable";
import ResponsiveStack from "./ResponsiveStack";

import { createTheme, ThemeProvider } from '@mui/material/styles';
import Hero from "./Hero";
import { FormControlLabel, FormGroup, Paper, Switch } from '@mui/material';

const theme = createTheme({
  palette: {
    primary: {
      light: '#0B3B55',
      main: '#0B3B55',
      dark: '#0B3B55',
    },
  },
});

export default function App() {

  const [auth, setAuth] = React.useState(true);

  const handleChange = (event) => {
    setAuth(event.target.checked);
  };

  return (
    <ThemeProvider theme={theme}>
      <Header auth={auth} />
      <main>
        <Hero auth={auth} />
        {/* <ResponsiveStack /> */}

      </main>

      {/* delete */}
      <FormGroup>
        <FormControlLabel
          control={
            <Switch
              checked={auth}
              onChange={handleChange}
              aria-label="login switch"
            />
          }
          label={auth ? 'Logout' : 'Login'}
        />
      </FormGroup>

    </ThemeProvider>
  );
}
