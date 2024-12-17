const films = [
    {
        title: 'Star Wars',
        year: 1977,
        director: 'George Lucas',
        imdbRating: 8.6
    },
    {
        title: 'The Godfather',
        year: 1972,
        director: 'Francis Ford Coppola',
        imdbRating: 9.2
    },
    {
        title: 'My Neighbour Totoro',
        year: 1988,
        director: 'Hayao Miyazaki',
        imdbRating: 8.2
    },
    {
        title: 'Back to the Future',
        year: 1985,
        director: 'Robert Zemeckis',
        imdbRating: 8.5
    },
    {
        title: 'The Room',
        year: 2003,
        director: 'Tommy Wiseau',
        imdbRating: 3.7
    },
    {
        title: 'Das Cabinet des Dr. Caligari',
        year: 1920,
        director: 'Robert Wiene',
        imdbRating: 8.1
    }
];

async function getFilm(index) {
    return films[index];
}

async function getFilms() {
    const serverUrl = 'http://localhost:50005/api/steam-app-list';  
    try {
      const response = await fetch(serverUrl); 
  
      if (!response.ok) {
        throw new Error(`Error: ${response.status}`);
      }
  
      const data = await response.json();  
      console.log('Steam App List:', data);  
      return data;
  
    } catch (error) {
      console.error('Failed to fetch Steam app list:', error.message);  
    }
}


export default { getFilm, getFilms };
