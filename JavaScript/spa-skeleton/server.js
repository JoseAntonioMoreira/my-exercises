const express = require('express');
const path = require('path');
const axios = require("axios");
const cors = require("cors");

const app = express();

app.use(cors());

app.get('/api/steam-app-list', async (req, res) => {
    try {
        const axios = require('axios');
        const response = await axios.get('https://api.steampowered.com/ISteamApps/GetAppList/v2/');
        res.json(response.data);
    } catch (error) {
        console.error('Error fetching Steam app list:', error);
        res.status(500).json({ error: 'Failed to fetch data from Steam API' });
    }
});

app.use(express.static(path.join(__dirname)));

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html'));
});

const PORT = 50005;

app.listen(PORT, () => {
    console.log('Server is running on port: ' + PORT);
});
