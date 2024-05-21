import Button from "../global/Button/index.jsx"
import styles from "./styles.module.css"
import { abrirPorta } from "../../../public/js/scanTag.js"
import gif from "../../../public/assets/images/gifs/conectar.gif"

  




export default function ModalPorta({ funcao, porta }) {
  return (
    <div className={styles.container}>
      <div className={styles.paragrafos}>
        <p>Para escanear o livro, é necessário selecionar a porta serial que o leitor está conectado</p>
        <p>Como mostrado no GIF abaixo, a porta pode ter um nome específico</p>
        <p>Dependendo do sistema operacional, a porta pode ter um nome diferente</p>
        <p>Windows: COMx, onde "x" é o número da porta</p>
        <p>Linux e MacOS: ttyUSBx, onde "x" é o número da porta</p>
      </div>
      <div className={styles.divGif}>
        <img src={gif} alt="GIF" className={styles.gif} />
      </div>
      <div className={styles.divBotao}>
        <Button tipoBotao={"primario"} onClick={() => abrirPorta(9600).then((res) => { funcao(res) })}>
          Conectar
        </Button>
      </div>
    </div>
  )
}
