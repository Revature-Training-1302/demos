// iterating through the array characters using 
// character is like a placeholder/counter 
for(const character of characters) {
    htmlText += `<h1>${character.name}</h1>`;
    htmlText += `<h2>Height: ${character.height}</h2>`;
}
