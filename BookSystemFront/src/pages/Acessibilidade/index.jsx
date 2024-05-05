import EstruturaPagina from "../../components/global/EstruturaPagina";
import style from "./styles.module.css"



function Acessibilidade() {
    return (
        <EstruturaPagina>
            <div className={style.textoAcessibilidade}>

                <p>Este site foi desenvolvido para que pessoas com deficiência visual, baixa visão, daltonismo, deficiência auditiva e mobilidade reduzida possam navegar por meio de recursos como alto contraste, aumento de fonte, teclas de atalho, tradução para a Língua Brasileira de Sinais e navegação por teclado.</p>

                <p>Para aumentar a fonte, é só clicar no símbolo de A+ em nossa barra de acessibilidade. Caso queira voltar ao tamanho de fonte original, é só clicar em A-.</p>

                <p>Se for necessário, você também pode usar o zoom nativo do seu navegador, pressionando as teclas <b>“Ctrl” e “+”</b> para aumentar todo o site e <b>“Ctrl” e “-“</b> para diminuir. Para voltar ao padrão, pressione <b>“Ctrl” e “0”</b>.</p>

                <p>Este site tem melhor acessibilidade quando acessado nas versões mais atualizadas do seu navegador web. Utilize sempre a versão mais recente de seu software.</p>

                <p>Teclas de atalho por navegadores</p>
                <p><b>Internet Explorer e Google Chrome:</b></p>

                <p><b>“Alt” + “1”</b> - ir para o conteúdo</p>
                <p><b>“Alt” + “2”</b> - ir para o menu</p>
                <p><b>“Alt” + “3”</b> - ir para o rodapé</p>
                <p><b>Firefox:</b></p>

                <p><b>“Alt” + “Shift” + “número”</b></p>
                <p><b>Opera:</b></p>

                <p><b>“Shift” + “Escape” + “número”</b></p>
                <p><b>Safari e OmniWeb:</b></p>

                <p><b>“Ctrl” + “número”</b></p>
                <p>Navegação por tabulação</p>
                <p>Use a tecla Tab para navegar por elementos que recebem ação do usuário no site, tais como links, botões, campos de formulário e outros na ordem em que eles são apresentados na página, e Shift + Tab para retornar. Use as setas direcionais para acessar as informações textuais.</p>

                <p>Sugestões de programas disponíveis para pessoas com deficiência</p>
                <p>- Nitrous Voice Flux: controla o computador por voz. Gratuito;</p>
                <p>- NVDA: software livre para ler tela – vários idiomas (Windows);</p>
                <p>- YeoSoft Text: leitor de tela em inglês e português;</p>
                <p>- Jaws for Windows: leitor de tela – vários idiomas;</p>
                <p>- Virtual Vision: leitor de telas em português do Brasil;</p>
                <p>- DOSVOX: sistema para deficientes visuais (Windows ou Linux).</p>
                <p>- Talkback: leitor de tela disponível em smartphones Android.</p>
                <p>Observação: leia no manual do leitor de telas sobre a melhor forma de navegação em páginas web.</p>

                <p>LIBRAS - Língua Brasileira de Sinais</p>
                <p>Este site é acessível em LIBRAS através do <a href="http://www.vlibras.gov.br/" target="_blank" className={style.link}>VLibras</a>.</p>
                <p>-Do lado direito de cada página do site existe o ícone de um Widget informando que o site é acessível em LIBRAS.</p>
                <p>-Para traduzir, basta clicar sobre o ícone e selecionar o texto que deseja traduzir.</p>

            </div >
        </EstruturaPagina>


    )
}

export default Acessibilidade;