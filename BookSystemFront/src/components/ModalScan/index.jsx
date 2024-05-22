import { lerPorta } from "../../../public/js/scanTag"
import Button from "../global/Button"
import styles from "./styles.module.css"

export default function ModalScan({ porta, dados }) {
  return (
    <div className={styles.container}>
        <Button tipoBotao={"primario"} type="button" onClick={() => lerPorta(porta, dados)}>
            Escanear
        </Button>
    </div>
  )
}
