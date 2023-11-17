function createLogoElement(linkHomePage){
    // Create the logo <a> element
    const logoLink = document.createElement('a');
    //logoLink.href = './index.html';
    logoLink.href = linkHomePage;
    logoLink.className = 'flex items-center';
  
    // Create the logo <img> element
    const logoImg = document.createElement('img');
    logoImg.src = 'https://flowbite.com/docs/images/logo.svg';
    logoImg.className = 'h-8 mr-3';
    logoImg.alt = 'Flowbite Logo';
  
    // Create the <span> for the site name
    const siteNameSpan = document.createElement('span');
    siteNameSpan.className = 'self-center text-2xl font-semibold whitespace-nowrap dark:text-white';
    siteNameSpan.textContent = 'Subacom DMS';
  
    // Append logoImg and siteNameSpan to logoLink
    logoLink.appendChild(logoImg);
    logoLink.appendChild(siteNameSpan);
    return logoLink
}

function createMobileMenuButton(){
    // Create the mobile menu button
    const mobileMenuButton = document.createElement('button');
    mobileMenuButton.type = 'button';
    mobileMenuButton.setAttribute('data-collapse-toggle', 'navbar-sticky');
    mobileMenuButton.className = 'inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600';
  
    // Create the mobile menu icon
    // const mobileMenuIcon = document.createElement('svg');
    // mobileMenuIcon.className = 'w-5 h-5';
    // mobileMenuIcon.setAttribute('xmlns', 'http://www.w3.org/2000/svg');
    // mobileMenuIcon.setAttribute('viewBox', '0 0 17 14');
    // mobileMenuIcon.innerHTML = '<path stroke="#9CA3AF" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15"/>';

    const mobileMenuIcon = 
    `<svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15"/>
    </svg>`;
  
    // Append the mobile menu icon to the mobile menu button
    //mobileMenuButton.appendChild(mobileMenuIcon);
    mobileMenuButton.innerHTML=mobileMenuIcon
    return mobileMenuButton
}

let currentMenuOption = 0;

function createNavbar(linkHomePage) {
    // Create the <nav> element
    const nav = document.createElement('nav');
    nav.className = 'bg-white dark:bg-gray-900 fixed w-full z-20 top-0 left-0 border-b border-gray-200 dark:border-gray-600';
  
    // Create the <div> with class 'max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4'
    const divMaxWidth = document.createElement('div');
    divMaxWidth.className = 'max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4';
    
    //Logo component
    const logoElement = createLogoElement(linkHomePage)
  
    // Create the menu <div> with class 'flex md:order-2'
    const menuDiv = document.createElement('div');
    menuDiv.className = 'flex md:order-2';
  
    // Create the 'Generar Reporte' button
    const reportButton = document.createElement('button');
    reportButton.type = 'button';
    reportButton.className = 'text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center mr-3 md:mr-0 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800';
    reportButton.textContent = 'Generar Reporte';
    const linkReportButton = document.createElement('a');
    linkReportButton.href='../../../templates/Reporte/reporte.html'
    linkReportButton.appendChild(reportButton)
  
    // Create the mobile menu button
    const mobileMenuButton = createMobileMenuButton()
  
    // Append the 'Generar Reporte' button and mobile menu button to the menu div
    menuDiv.appendChild(linkReportButton);
    menuDiv.appendChild(mobileMenuButton);
  
    // Create the menu container div with class 'items-center justify-between hidden w-full md:flex md:w-auto md:order-1'
    const menuContainerDiv = document.createElement('div');
    menuContainerDiv.className = 'items-center justify-between hidden w-full md:flex md:w-auto md:order-1';
    menuContainerDiv.id = 'navbar-sticky';
  
    // Create the <ul> for the menu items
    const menuList = document.createElement('ul');
    menuList.className = 'flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700';
  
    // Create an array of menu item data
    const menuItems = [
      { text: 'Inicio', href: '../../../templates/index.html', current: false, bgClass: 'bg-blue-700', textClass: 'text-white' },
      { text: 'Necesidades', href: '../../../templates/Necesidades/necesidades.html', current: false, bgClass: 'bg-transparent', textClass: 'text-white' },
      { text: 'Pedidos', href: '../../../templates/Pedidos/pedidos.html', current: false, bgClass: 'bg-transparent', textClass: 'text-white' },
      { text: 'Empleado', href: '../../../templates/Empleado/empleado.html', current: false, bgClass: 'bg-transparent', textClass: 'text-white' },
    ];
  
    // Create menu items and append them to the menu list
    //menuItems[0].current=true
    menuItems.forEach((item,index) => {
      const menuItem = document.createElement('li');
      menuItem.addEventListener('click', ()=>{
        menuItems.forEach(menuItem=>menuItem.current=false)
        currentMenuOption=index;
        //menuItems[index].current=true;
        //console.log(currentMenuOption)
        })
        console.log(currentMenuOption)
        if (currentMenuOption==index) {
            menuItems[index].current=!menuItems[index].current;
        }
      console.log(currentMenuOption, menuItems[currentMenuOption].current)
      menuItems[currentMenuOption].current=!menuItems[currentMenuOption].current;
      const menuLink = document.createElement('a');
      menuLink.href = item.href;
      menuLink.className = `block py-2 pl-3 pr-4 ${item.textClass} rounded ${item.current ? 'md:bg-transparent' : 'hover:bg-gray-500'} ${item.current ? 'md:text-white' : 'md:hover:text-grey-300'} md:p-0 md:dark:${item.current ? 'md:text-blue-500' : 'md:text-white md:hover:text-blue-300 md:hover:bg-transparent'}`;
      menuLink.textContent = item.text;
      if (item.current) {
        menuLink.setAttribute('aria-current', 'page');
      }
      menuItem.appendChild(menuLink);
      menuList.appendChild(menuItem);
    });
  
    // Append the menu list to the menu container div
    menuContainerDiv.appendChild(menuList);
  
    // Append all elements to their respective parents
    divMaxWidth.appendChild(logoElement);
    divMaxWidth.appendChild(menuDiv);
    divMaxWidth.appendChild(menuContainerDiv);
    nav.appendChild(divMaxWidth);
  
    // Return the created <nav> element
    return nav;
  }
  
  // Add the created <nav> element to the document body
  document.body.appendChild(createNavbar("../../../templates/index.html"));