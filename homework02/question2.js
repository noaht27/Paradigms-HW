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
    /* ... Your implementation here ... */
    // You can use the readFile from the fs module
    // See the documentation: https://nodejs.org/en/knowledge/file-system/how-to-read-files-in-nodejs/
    // The CSV files are comma-separated

    return /* array of objects */;
}


function query1(defects){
    /* Your implementation here */
    return /*...*/;    
}

function query2(defects){
    /* Your implementation here */
    return /*...*/;    
}

function query3(defects){
    /* Your implementation here */
    return /*...*/;    
}

function query4(defects){
    /* Your implementation here */
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