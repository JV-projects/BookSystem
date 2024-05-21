let port;
let i = 0;
let teste;
let reader;
const bufferSize = 10;
let buffer = new ArrayBuffer(bufferSize)
let buffer1 = new ArrayBuffer(bufferSize)
let array = []

document.getElementById('abrir').addEventListener('click', async () => {


    // Prompt user to select any serial port.

    port = await navigator.serial.requestPort();

    await port.open({ baudRate: 9600 })

    console.log(port)


});


const guardarByte = (uint8) => {
    for (let i = 0; i < uint8.length; i++) {
        array.push(uint8[i])
    }
}

const exibeSerial = (array) => {
    array = array.toString()
    array = array.replaceAll(',', "")
    return array
}


document.getElementById('enviar').addEventListener('click', async () => {


    const input = document.getElementById('input').value

    const encoder = new TextEncoder();
    const writer = port.writable.getWriter();
    await writer.write(encoder.encode('g'));
    writer.releaseLock();


    /*while (port && port.readable) {
        try {
            try {
                reader = port.readable.getReader({ mode: 'byob' });
            } catch {
                reader = port.readable.getReader();
            }

            let buffer = null;
            for (; ;) {
                const { value, done } = await (async () => {
                    if (reader instanceof ReadableStreamBYOBReader) {
                        if (!buffer) {
                            buffer = new ArrayBuffer(bufferSize);
                        }
                        const { value, done } =
                            await reader.read(new Uint8Array(buffer, 0, bufferSize));
                        buffer = value?.buffer;
                        return { value, done };
                    } else {
                        return await reader.read();
                    }
                })();

                if (value) {
                    guardarByte(value)
                    i++
                }
                if (done) {
                    break;
                }
            }
        } catch (e) {
            console.error(e);
            await new Promise((resolve) => {
                if (e instanceof Error) {
                    console.log(`<ERROR: ${e.message}>`, resolve);
                }
            });
        } finally {
            if (reader) {
                reader.releaseLock();
                reader = undefined;
            }
        }
    }*/





    const textDecoder = new TextDecoderStream();
    const readableStreamClosed = 
    port.readable.pipeTo(textDecoder.writable);
    const reader = textDecoder.readable.getReader();

    // Listen to data coming from the serial device.
    while (true) {
        const { value, done } = await reader.read();
        let i = 0;
        if (done) {
            // Allow the serial port to be closed later.
            reader.releaseLock();
            break;
        }
        console.log(value)
        guardarByte(value)
        i++;
    }
})

document.getElementById('exibir').addEventListener('click', () => {
    console.log(array)
    console.log(array.toString())
    console.log(exibeSerial(array))
    array = []
})

