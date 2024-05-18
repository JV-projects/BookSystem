let port;
let i = 0;
let teste;
let reader;
const bufferSize = 10;
let buffer = new ArrayBuffer(bufferSize)
let buffer1 = new ArrayBuffer(bufferSize)
let array = []

export default async function abrirPorta(velocidade) {
    let porta = await navigator.serial.requestPort();

    await porta.open({baudRate: velocidade})

    console.log(porta)

    return porta
}

