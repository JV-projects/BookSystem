import { CSSGlobalVariables } from "css-global-variables";

const cssVariaveis = new CSSGlobalVariables()
let fonte = 16;

function setFonte(valor) {
    fonte = valor;
}

export {cssVariaveis, fonte, setFonte}


