import styles from "./styles.module.css"
import EstruturaPagina from "../../components/global/EstruturaPagina"
import Button from "../../components/global/Button"
import Input from "../../components/global/Input"

export default function NovoEmprestimo(props) {

	return (
		<>
			<EstruturaPagina>
				<div className={styles.containerMain}>
					<h1 className={styles.titulo}>Novo empréstimo</h1>
					<p className={styles.subtitulo}>Insira as informações para criar um empréstimo</p>

					<div className={styles.containerArea}>


						{/* Usuário */}

						<div className={styles.areaBusca}>
							<p>Insira o CPF do usuário para encontrá-lo no sistema</p>

							<div className={styles.barraPesquisa}>
								<Input placeholder="CPF" />
								<Button tipoBotao="primario">
									<span className="material-symbols-outlined">search</span>
								</Button>
							</div>

							<div className={styles.dadosUsuario}>
								<p>Jane Austen</p>
								<div className={styles.usuarioContato}>
									<p>
										<span className="material-symbols-outlined">mail</span>
										jane.austen@gmail.com
									</p>
									<p>
										<span className="material-symbols-outlined">phone</span>
										11 90022-3355
									</p>
								</div>

							</div>

							{/* Livro */}

							<h3>
								Buscar por mais livros
							</h3>
							<p>Insira o ISBN do Livro</p>
							<div className={styles.barraPesquisa}>
								<Input placeholder="ISBN" />
								<Button>
									<span className="material-symbols-outlined">search</span>
								</Button>
							</div>

							<div className={styles.cardLivro}>
								<div className={styles.infoLivro}>
									<p>Java 8: Como Programar</p>
									<p>Paul Deitel</p>
								</div>
								<Button tipoBotao="terciarioConfirma">
									Adicionar
								</Button>
							</div>

						</div>

						<div className={styles.areaResumo}>
							<div className={styles.containerResumo}>
								<div className={styles.headerResumo}>
									<p>Itens de empréstimo</p>
									<p>0 itens</p>
								</div>

								<div className={styles.itemEmprestimo}>
									<div className={styles.infoLivro}>
										<p>Java 8: Como Programar</p>
										<p>Paul Deitel</p>
									</div>
									<Button tipoBotao="terciarioCancela">
										Remover
									</Button>
								</div>
								<div className={styles.itemEmprestimo}>
									<div className={styles.infoLivro}>
										<p>Java 8: Como Programar</p>
										<p>Paul Deitel</p>
									</div>
									<Button tipoBotao="terciarioCancela">
										Remover
									</Button>
								</div> 
							</div>

							<div className={styles.containerPeriodo}>
								<div className={styles.retirada}>
									<label>Retirada</label>
									<Input placeholder="00/00/0000"/>
								</div>
								<div className={styles.devolucao}>
									<label>Devolução</label>
									<Input placeholder="00/00/0000"/>
								</div>
							</div>

							<div className={styles.containerBotoes}>
								<Button tipoBotao="terciarioCancela">
									Cancelar
								</Button>
								<Button tipoBotao="terciarioConfirma">
									Finalizar
								</Button>
							</div>
						</div>


					</div>

				</div>
			</EstruturaPagina>
		</>
	)

}