import { useState } from 'react'
import styles from './styles.module.css'
import EstruturaPagina from '../../components/global/EstruturaPagina'
import Button from '../../components/global/Button'
import Input from '../../components/global/Input'
import { Link } from 'react-router-dom'
import TopoPagina from '../../components/global/TopoPagina'
import useSWR from 'swr'
import fetcher from '../../util/fetcher'
import apiUrl from '../../util/apiUrl'

export default function NovoEmprestimo() {
	const { usuarios, usuariosError, usuariosIsLoading } = useSWR(`${apiUrl}/usuarios`, fetcher)
	const { livros, livrosError, livrosIsLoading } = useSWR(`${apiUrl}/livros`, fetcher)

	const [cpf, setCpf] = useState([])
	const [isbn, setIsbn] = useState([])
	const [itensEmprestimo, setItensEmprestimo] = useState([])
	const [dataRetirada, setDataRetirada] = useState(null)
	const [dataDevolucao, setDataDevolucao] = useState(null)

	const usuario = usuarios != null ? usuarios.find(usuario => usuario.cpf === cpf) : null
	const listaLivros = livros != null ? livros.filter(livro => livro.isbn.includes(isbn)) : []
	
	const status = 'Disponível'

	async function handleSubmit() {
        const emprestimo = {
			itensEmprestimo,
            dataRetirada,
			dataDevolucao,
            status,
			usuario
        }

        try {
            const response = await fetch(`${apiUrl}/emprestimos/username/${usuario.username}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(emprestimo)
            })
            if (!response.ok) {
                throw new Error("Erro ao cadastrar o empréstimo.")
            }
        } catch (error) {
            setErrorMessage("Erro ao cadastrar o empréstimo. Verifique os dados informados.")
        }
    }

	function handleAdicionar(titulo, autor) {
		setItensEmprestimo([...itensEmprestimo, {titulo: titulo, autor: autor}])
	}
	
	function handleRemover(index) {
		setItensEmprestimo(itensEmprestimo.filter((livroAdicionado, i) => i != index))
	}

	return (
		<EstruturaPagina>
			<TopoPagina
				titulo="Novo empréstimo"
				subtitulo="Insira as informações para criar um empréstimo"
				link="/gerenciamento" />
			<form className={styles.containerArea} onSubmit={handleSubmit}>
				{/* Usuário */}
				<div className={styles.areaBusca}>
					<p>Insira o CPF do usuário para encontrá-lo no sistema</p>
					<div className={styles.barraPesquisa}>
						<Input placeholder="CPF" value={cpf} onChange={e => setCpf(e.target.value)}/>
						<Button tipoBotao="primario" type='button'>
							<span className="material-symbols-outlined">search</span>
						</Button>
					</div>
					{usuariosError ? (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Ocorreu um erro.</p>
						</div>
					) : usuariosIsLoading ? (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Carregando...</p>
						</div>
					) : usuario != null ? (
						<div className={styles.areaTexto}>
							<p className={styles.paragrafo}>{usuario.nome}</p>
							<div className={styles.areaDados}>
								<p className={styles.paragrafo}>
									<span className="material-symbols-outlined">mail</span>
									{usuario.email}
								</p>
								<p className={styles.paragrafo}>
									<span className="material-symbols-outlined">phone</span>
									{usuario.telefone}
								</p>
							</div>
						</div>
					) : (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Nenhum usuário com esse CPF encontrado.</p>
						</div>
					)}
					{/* Livro */}
					<h3>Buscar por mais livros</h3>
					<p>Insira o ISBN do Livro</p>
					<div className={styles.barraPesquisa}>
						<Input placeholder="ISBN" value={isbn} onChange={e => setIsbn(e.target.value)}/>
						<Button type='button'>
							<span className="material-symbols-outlined">search</span>
						</Button>
					</div>
					{livrosError ? (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Ocorreu um erro.</p>
						</div>
					) : livrosIsLoading ? (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Carregando...</p>
						</div>
					) : listaLivros.length > 0 ? (
						listaLivros.map((livroLista, i) => (
							<div className={styles.cardLivro} key={i}>
								<div className={styles.areaTexto}>
									<h1 className={styles.titulo}>{livroLista.titulo}</h1>
									<p className={styles.destaque}>{livroLista.autor}</p>
								</div>
								<Button tipoBotao="terciarioConfirma" type='button' onClick={() => handleAdicionar()}>Adicionar</Button>
							</div>
						))
					) : (
						<div className={styles.areaTextoCentralizado}>
							<p className={styles.paragrafo}>Nenhum livro com esse ISBN encontrado.</p>
						</div>
					)}
				</div>
				<div className={styles.areaResumo}>
					<div className={styles.containerResumo}>
						<div className={styles.headerResumo}>
							<p>Itens de empréstimo</p>
							<p>{itensEmprestimo.length} itens</p>
						</div>
						{itensEmprestimo.length > 0 ? (
							itensEmprestimo.map((livroAdicionado, i) => (
								<div className={styles.itemEmprestimo} key={i}>
									<div className={styles.areaTexto}>
										<h1 className={styles.titulo}>{livroAdicionado.titulo}</h1>
										<p className={styles.destaque}>{livroAdicionado.autor}</p>
									</div>
									<Button tipoBotao="terciarioCancela" type='button' onClick={() => handleRemover(i)}>Remover</Button>
								</div>
							))
						) : (
							<div className={styles.areaTextoCentralizado}>
								<p className={styles.paragrafo}>Nenhum livro adicionado.</p>
							</div>
						)}
					</div>
					<div className={styles.containerPeriodo}>
						<div className={styles.retirada}>
							<label>Retirada</label>
							<div className={styles.calendario}>
								<Input placeholder="00/00/0000" type="date" value={dataRetirada} onChange={e => setDataRetirada(e.target.value)}/>
								<span className="material-symbols-outlined">calendar_today</span>
							</div>
						</div>
						<div className={styles.devolucao}>
							<label>Devolução</label>
							<div className={styles.calendario}>
								<Input placeholder="00/00/0000" type="date" value={dataDevolucao} onChange={e => setDataDevolucao(e.target.value)}/>
								<span className="material-symbols-outlined">calendar_today</span>
							</div>
						</div>
					</div>
					<div className={styles.containerBotoes}>
						<Button tipoBotao="terciarioCancela" to="/gerenciamento" type='button'>Cancelar</Button>
						<Button tipoBotao="terciarioConfirma" type='submit'>Finalizar</Button>
					</div>
				</div>
			</form>
		</EstruturaPagina>
	)

}