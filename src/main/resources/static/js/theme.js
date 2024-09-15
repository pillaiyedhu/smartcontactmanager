let currentTheme = getTheme();

document.addEventListener("DOMContentLoaded",() => {  
    changeTheme();
});


function changeTheme(){
    changePageTheme(currentTheme,"");
    const themeButton = document.querySelector("#theme_button");
    //console.log(themeButton);

    themeButton.addEventListener("click",(event)=>{
        let oldTheme = currentTheme;
        if(currentTheme=="dark"){
            currentTheme="light";
        }
        else{
            currentTheme="dark";
        }
        //console.log(currentTheme);
        changePageTheme(currentTheme,oldTheme);
    });
}

function changePageTheme(theme,oldTheme){
    setTheme(currentTheme);

    if(oldTheme){
        document.querySelector('html').classList.remove(oldTheme);
    }
    document.querySelector('html').classList.add(theme);

    document.querySelector("#theme_button").querySelector("span").textContent = theme == "light" ? "Dark" : "Light";

}


function setTheme(theme){
    localStorage.setItem("theme",theme);
}


function getTheme(){
    let theme = localStorage.getItem("theme");
    console.log(theme);
    return theme ? theme : "light";
}