## HTML
- HyperText Markup Language
- NOT a programming language
- This is the language that we use to define a "skeleton" of our front-end page
- We define which elements are on the page
- Leaving styling and logic to CSS and JS

### Terms/Definitions
- Element - something on a web page
    - ex: button, title, paragraph of text, image
- Tag - in the HTML code, we use tags to define elements
    - opening/closing tag: <div>child content</div>
    - self-closing tag: <img src = "url.com"/>
- Attribute - property of an element
    - ex: class, name, id, width, height
    - <div class = "login"></div>


### Structure of an HTML page:
- root html tag which contains head and body
- Head - metadata about the project, title, stylings, scripts
- Body - content goes in the body, we also see scripts usually
- In VScode
    - Type "html:5" and hit tab
    - Type out an ! and hit tab

### How to View HTML page
- Find the file in your file directory and open in browser
    - requires us to refresh every time we make a change
- The more responsive way is to install an extension in Visual Studio Code called Live Server
    - To install this, go to the extensions menu in VScode, look up Live Servet
    - Click on the extension and "Install"
    - Once it's installed, we can right-click an HTML file and select "Open with Live Server"
    - Notice the address bar, example: "http://127.0.0.1:5500/hello.html"
    - to change port number, click the Gear icon next to the extension and go down to port number, you will have to edit the settings.json

### Elements
- Headers
    - h1- h6, number indicates precedence, 1 being the highest
- Paragraph tag
    - p - used for text
    - VScode tip: type "lorem" and enter to get some dummy text
- Div tag
    - div - used to divide sections of the web page
    - almost like containers for different pieces of your web page
- Lists 
    - Unordered Lists
        - doesn't have numbers
    - Ordered Lists
        - does have numbers/letters
    - Used to store a list of values/data
    - Tags: ol (ordered list), ul (unordered list), and li (list item)
- Anchor tag
    - used to click links and redirect to a different page
    - can do public urls like google.com or the path to a local file
    - a tag with href attribute
        - ex: <a href = "http://google.com">Click me</a>
- Images and Videos
    - used to put media on web page
    - src attribute contains the link/location to the resource

### Inline vs Block elements
- Inline means that 2 or more elements can share horizontal space
- Block elements start a new line every time
- Examples of inline: a tags, image tags, span tags
- Examples of block: headers, paragraph, divs
- We can use the break tag to start a new line regardless of whether it's inline or block

### Tables
- used to store multi-field, multi-dimensional information
- table tag - represents the entire table
- tbody - represents the table body
- thead - represents the table head
- tr - table row
- td - table data, an indidual cell in the table
- th - header item

----------------------
test | test 2 | test