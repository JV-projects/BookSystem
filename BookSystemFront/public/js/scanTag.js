let array = []

export async function abrirPorta(velocidade) {
    let porta = await navigator.serial.requestPort();

    await porta.open({ baudRate: velocidade })

    console.log(porta)

    return porta
}

export async function enviarSerial(porta) {
    const encoder = new TextEncoder();
    const writer = porta.writable.getWriter();
    await writer.write(encoder.encode('g'));
    writer.releaseLock();
}

export async function lerPorta(porta, set) {

    enviarSerial(porta)

    const textDecoder = new TextDecoderStream();
    const readableStreamClosed = porta.readable.pipeTo(textDecoder.writable)
    const leitor = textDecoder.readable.getReader();

    while (true) {
        const { value, done } = await leitor.read();
        if (done) {
            leitor.releaseLock();
            break;
        }
        console.log(value)
        guardarByte(value)
        set(array)
    }
}

function guardarByte(bytes) {
    for (let i = 0; i < bytes.length; i++) {
        array.push(bytes[i])
    }

    return array
}

export function arrayToString(array) {
    array = array.toString()
    array = array.replaceAll(',', "")
    return array
}


