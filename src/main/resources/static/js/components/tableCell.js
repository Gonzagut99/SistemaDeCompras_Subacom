
let idRowCell = (id)=>{
    let th = document.createElement('th');
    th.scope = "row";
    th.className = "px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white";
    th.textContent = id;
    return th;
}

let valueCell = (value)=>{
    let newTd = document.createElement('td');
    newTd.className = "px-6 py-4";
    newTd.textContent = value;
    return newTd;
}

let textButtonCell = (buttonText, callback)=>{
    let td = document.createElement('td');
    td.className = "px-6 py-4 text-center";
    let a = document.createElement('a');
    a.href = "#";
    a.className = "font-medium text-blue-600 dark:text-blue-500 hover:underline";
    a.textContent = buttonText;
    a.addEventListener("click", callback)
    td.appendChild(a);
    return td;
}

export {idRowCell,valueCell,textButtonCell};