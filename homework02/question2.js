// Noah Thompson
// 9 February 2026
// question2.js

// Q2.1 - Create the Object's Type
function Defect(bug_id, component, status, resolution, summary, blocks, depends, fixed_by_username, fixed_by_real_name){
    this.bug_id = bug_id;
    this.component = component;
    this.status = status;
    this.resolution = resolution;
    this.summary = summary;
    this.blocks = blocks;
    this.depends = depends;
    this.fixed_by_username = fixed_by_username;
    this.fixed_by_real_name = fixed_by_real_name;
}


function loadObjects(){
    // You can use the readFile from the fs module
    // See the documentation: https://nodejs.org/en/knowledge/file-system/how-to-read-files-in-nodejs/
    // The CSV files are comma-separated

    // import the NodeJS modules
    const fs = require('fs');               // module for file I/O
    const readline = require("readline");   // module for reading line-by-line from file

    // create input streams
    let defectsCSV = fs.readFileSync("defects.csv","utf8");  
    let dependsCSV = fs.readFileSync("defect_depends.csv","utf8");
    let blocksCSV = fs.readFileSync("defect_blocks.csv","utf8");
    let developersCSV = fs.readFileSync("developers.csv","utf8");

    // initializing my defects array
    let defects_array = [];

    // Reads defects CSV line-by-line
    let defect_row = defectsCSV.split("\n");
    defect_row.shift();
    defect_row.forEach(row =>{
        /* logic here to parse the rows */
        // I  went through the CSV and just decided to look at column and seperate by which columns i wanted
        let bug_id = Number(row.split(",")[0]);
        let component = row.split(",")[1];
        let status = row.split(",")[2];
        let resolution = row.split(",")[3];
        let summary = row.split(",")[4];
        let fixed_by_username = row.split(",")[13].trim();

        // protypal instantiation. note i set real name to null as a requirement later on
        let defect1 = new Defect(bug_id, component, status, resolution, summary, [], [], fixed_by_username, null);
        defects_array.push(defect1);
    });

    let dependrow = dependsCSV.split("\n");
    dependrow.shift();
    dependrow.forEach(row =>{
        /* parse the rows */
        // simply split the row and we have the two pieces of information we need
        let [bug_id, depends_id] = row.split(",");
        bug_id = Number(bug_id);

        // similar to how I did question1, using .find() on defects aray, and then push to depends array
        defects_array.find((n) => n.bug_id == bug_id).depends.push(Number(depends_id));
    });

    let blockrow = blocksCSV.split("\n");
    blockrow.shift();
    blockrow.forEach(row =>{
        /* parse the rows */
        let [bug_id, blocks_id] = row.split(",");
        bug_id = Number(bug_id);

        // push to blocks array this time
        defects_array.find((n) => n.bug_id == bug_id).blocks.push(Number(blocks_id));
    });

    let devsrow = developersCSV.split("\n");
    devsrow.shift();
    devsrow.forEach(row =>{
        /* parse the rows */   
        let [real_name, username] = row.split(","); 
        
        // this was a little different then other two because had to go for each 
        // username, not just one so needed forEach. 
        defects_array.forEach(defect => {
            if (defect.fixed_by_username == username) {
                // already initialized real name as null, so dont have to worry about
                // cases where real name isn't found
                defect.fixed_by_real_name = real_name;
            }
        });
    });

    /* array of objects */
    return defects_array;
}


function query1(defects){
    // number of defects solved by developers with status =”RESOLVED” and resolution="FIXED"
    let solved = defects.filter((n) => n.status == "RESOLVED" && n.resolution == "FIXED");
    console.log(solved.length);
    return Number(solved.length);    
}

function query2(defects){
    // number of defects whose summary attribute include the word "buildbot" regardless of case 
    let build_bot = defects.filter((n) => n.summary.toLowerCase().split(" ").some(word => word == "buildbot"));
    console.log(build_bot.length)

    return Number(build_bot.length)   
}

function query3(defects){
    // percentage of issues not solved yet
    // filter by not resolved
    let unresolved = defects.filter((n) => n.status != "RESOLVED");
    let defect_length = defects.length;

    // percentage is (unresolved / all defects) * 100
    let percent = (unresolved.length / defect_length) * 100;
    console.log(percent);

    return Number(percent);    
}

function query4(defects){
    // find most defective component
    let defect_components = {};

    defects.forEach(defect => {
        defect_components[defect.component] = (defect_components[defect.component] || 0) + 1;
    });
    console.log(defect_components);
    return /*...*/;    
}

function query5(defects){
    /* Your implementation here */
    return /*...*/;    
}

function query6(defects){
    /* Your implementation here */
    return /*...*/;    
}


let defects = loadObjects();
query1(defects);
query2(defects);
query3(defects);
query4(defects);
query5(defects);
query6(defects);