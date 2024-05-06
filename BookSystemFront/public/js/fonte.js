const elemento = window.getComputedStyle(document.documentElement).fontSize

const fonteRaiz = parseInt(elemento)
let fonte = fonteRaiz

function setFonte(valor) {
    fonte = valor;
}

export {fonte, setFonte}


