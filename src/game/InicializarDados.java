package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicializarDados {

		private static List<Evento> listaEventos = new ArrayList<>();
		
		
		public static List<Evento> getListaEventosPosisitvos(){
			/**
			 * Cadastrar Eventos Positivos
			 */
			listaEventos.add(new EventoPositivo("Parabéns! Você realizou a coleta seletiva do lixo!",
										"A Coleta Seletiva é o primeiro e o mais importante passo para fazer "
										+ "com que vários tipos de resíduos sigam seu caminho para reciclagem "
										+ "ou destinação final ambientalmente correta, pois o resíduo separado "
										+ "corretamente deixa de ser lixo.", 
										new Consequencia("avancar"), 101));
			
			listaEventos.add(new EventoPositivo("Parabéns! Você reduziu o consumo de energia na sua residência.",
										 "A construção de estruturas de geração de energia pode causar muitos "
										+ "danos à Natureza, sendo assim, economizar energia é uma forma de "
										+ "proteger o meio ambiente e, também, de aliviar o seu bolso, já que "
										+ "as contas de luz ficam mais baratas",
										new Consequencia("jogarNovamente"),  102));
			
			listaEventos.add(new EventoPositivo("Você destinou materiais para a reciclagem.",
										"A reciclagem de materiais evita a degradação "
										+ "do meio ambiente, economizando matérias-primas para fabricação de novos produtos, "
										+ "auxilia o fortalecimento econômico de cooperativas de reciclagem, contribuindo "
										+ "para melhoria de vida dos catadores. Alem de contribuir para o aumento de vida "
										+ "útil dos aterros sanitários evitando que produtos recicláveis sejam destinados incorretamente.",
										new Consequencia("avancar"),  103));
			
			listaEventos.add(new EventoPositivo("Você reaproveitou a água da chuva.",
										"A captaçao e o aproveitamento da água da chuva reduz o uso de água potável em "
										+ "tarefas domésticas, além de contribuir para a redução dos custos públicos com "
										+ "tratamento e distribuição da água, consequentemente diminuindo o custo da fatura com água.",
										new Consequencia("avancar"),  104));
			
			listaEventos.add(new EventoPositivo("Que legal! Você substituiu as lâmpadas incandescentes da sua casa!",
										"Substituir as lampadas incandecentes por fluorescentes economiza em média 60% no consumo, "
										+ "evita a emissão de possivelmente 136kg de gás carbônico por ano e diminui o número de "
										+ "substituições, pois a fluorescente tem maior vida útil.",
										new Consequencia("jogarNovamente"),  105));
			
			listaEventos.add(new EventoPositivo("Parabéns! você Substituiu um aquecedor elétrico pelo solar.",
										"Um aquecedor solar gasta cerca R$ 0,0035 por litro de água aquecida, enquanto um aquecedor "
										+ "de gás R$ 0,64 e um chuveiro elétrico R$ 0,89. Continue cuidando do meio ambiente!",
										new Consequencia("jogarNovamente"),  106));
			
			listaEventos.add(new EventoPositivo("Consumidor consciente é aquele que escolhe embalagens reutilizáveis.",
										" Prefira produtos que podem ser usados, lavados e reutilizados, ao invés de serem descartados "
										+ "após a utilização. Essa é uma tendência em curso no mercado em geral, pois "
										+ "reduz a quantidade de lixo na coleta e aterros.",
										new Consequencia("avancar"),  107));
			
			listaEventos.add(new EventoPositivo("Aeeee, você nunca deixa os aparelhos eletrõnicos em stand-by.",
										"Nao deixar aparelhos eletrônicos em stand-by economiza em média 12% do consumo doméstico de "
										+ "energia elétrica. É bom para seu bolso e maravilhoso para natureza.",
										new Consequencia("avancar"),  108));
			
			listaEventos.add(new EventoPositivo("Seu telhado está lindo com esses painéis fotovoltaicos que você instalou.",
										"A instalaçao de painéis fotovoltaicos responsaveis por captar a energia solar, economiza nas "
										+ "despesas mensais com energia elétrica e evita a construção de novas usinas para produção de energia",
										new Consequencia("avancar"),  109));
			
//			listaEventos.add(new EventoPositivo("",
//										"",
//										new Consequencia(""),  110));
			/**
			 * Cadastrar Perguntas abaixo;
			 * Estrutura EventoQuetion -> new Question ("Pergunta", Map<>alternativas, consequenciaAcerto, consequenciaErro, id);
			 */
			Map<String, Boolean> alternativas = new HashMap<>(); 
			alternativas.put("100 mil toneladas", false);
			alternativas.put("68,9 mil toneladas", false);
			alternativas.put("500 mil toneladas", false);
			alternativas.put("228,4 mil toneladas", true);
			listaEventos.add(new Question("Quantas toneladas de lixo o Brasil produz por ano?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 1 ));
			//
			alternativas = new HashMap<>();
			alternativas.put("Até 50 anos", false);
			alternativas.put("Até 1000 anos", false);
			alternativas.put("Até 150 anos", false); 
			alternativas.put("Até 500 anos", true);
			listaEventos.add(new Question("Quanto tempo pode levar para uma pilha se decompor na Natureza?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"),  2));
			//
			alternativas = new HashMap<>();
			alternativas.put("Solar", false);
			alternativas.put("Bagaço de cana", false);
			alternativas.put("Heólica", true);
			alternativas.put("Hidrelétrica", false);
			listaEventos.add(new Question("Qual fonte de energia renovavel é destaque no Ceará?", alternativas, new Consequencia("jogarNovamente"), new Consequencia("ficarSemJogar"),  3));
			//
			alternativas = new HashMap<>();
			alternativas.put("Nitrogênio", true);
			alternativas.put("Metano", false);
			alternativas.put("Clorofluocarbonos", false);
			alternativas.put("Dióxido de Carbono", false);
			listaEventos.add(new Question("Qual dos gases abaixo não é um dos causadores do efeito estufa?", alternativas, new Consequencia("avancar"), new Consequencia("ficarSemJogar"),  4));
			//
			alternativas = new HashMap<>(); 
			alternativas.put("40 mil toneladas", true);
			alternativas.put("100 mil toneladas", false);
			alternativas.put("10 mil toneladas", false);
			alternativas.put("50 mil toneladas", false);
			listaEventos.add(new Question("Em media, quantos quilos de alimentos o Brasil desperdiça por dia?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 5));
			//
			alternativas = new HashMap<>();
			alternativas.put("10%", false);
			alternativas.put("90%", true);
			alternativas.put("46,5%", false);
			alternativas.put("50,2%", false);
			listaEventos.add(new Question("Qual o nivel de poluiçao dos automoveis em São Paulo?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 6));
			//
			alternativas = new HashMap<>();
			alternativas.put("Gasolina", false);
			alternativas.put("Diesel", false);
			alternativas.put("Etanol", true);
			alternativas.put("Querosene", false);
			listaEventos.add(new Question("Qual combustivel produzido no Brasil é considerado limpo e renovável?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"),  7));
			//
			alternativas = new HashMap<>();
			alternativas.put("Fluorescente Tubular", false);
			alternativas.put("Incandescente", true);
			alternativas.put("Fluorescente Compacta", false);
			alternativas.put("LED", false);
			listaEventos.add(new Question("Qual das lâmpadas abaixo mais degrada o meio ambiente?", alternativas, new Consequencia("jogarNovamente"), new Consequencia("voltar"), 8));
			//
			alternativas = new HashMap<>();
			alternativas.put("Borracha", false);
			alternativas.put("Plastico", false);
			alternativas.put("Ampolas de medicamento", true);
			alternativas.put("Tecido", false);
			listaEventos.add(new Question("Qual desses materiais não é reciclavel?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 9));
			//
			alternativas = new HashMap<>();
			alternativas.put("Certificaçao de economia de energia", true);
			alternativas.put("Certificaçao de reduçao de CO²", false);
			alternativas.put("Certificaçao de madeira reflorestada", false);
			alternativas.put("Certificaçao de produto reciclado", false);
			listaEventos.add(new Question("O que representa o selo Procel?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 10));
			//
			alternativas = new HashMap<>();
			alternativas.put("20,7 mil litros", false);
			alternativas.put("10,2 mil litros", false);
			alternativas.put("7,4 mil litros", false);
			alternativas.put("16,5 mil litros", true);
			listaEventos.add(new Question("Quantos litros de água uma torneira pode desperdiçar gotejando por um ano?", alternativas, new Consequencia("avancar"), new Consequencia("voltar"), 11));
			//
			alternativas = new HashMap<>();
			alternativas.put("Nivel reduzido de CO²", false);
			alternativas.put("Economia de energia", false);
			alternativas.put("Madeira reflorestada", true);
			alternativas.put("Produto reciclado", false);
			listaEventos.add(new Question("O selo FSC é uma certificaçao de...", alternativas, new Consequencia("avancar"), new Consequencia("ficarSemJogar"), 12));
			
			/**
			 * Cadastrar Imprevistos abaixo
			 */
			
			listaEventos.add(new EventoImprevisto("Você passou mais de 15 minutos no banho.", 
										"Um banho de 15 minutos gasta 135 litros de água. Se esse tempo diminui "
										+ "para 5 minutos, apenas 45 litros são utilizados. Se o chuveiro for elétrico"
										+ "o consumo de energia também é elevado. Seja consciente, tome banhos curtos",
										new Consequencia("voltar"),  50));
			
			listaEventos.add(new EventoImprevisto("Você jogou óleo de cozinha na pia, que feio!",
										"Um litro de óleo pode contaminar até 20 litros de água. Jogar óleo de cozinha"
										+ " na pia impõe risco de contaminação à mananciais, além de poder entupir as "
										+ "caixas de gordura de residências e estabelecimentos comerciais. Procure maneiras"
										+ " adequadas de descartar o óleo de cozinha, se possível, nos postos de coleta"
										+ " mais próximos da sua residência.",
										new Consequencia("voltar"), 51));
			
			listaEventos.add(new EventoImprevisto("Você promoveu uma queimada no quintal da sua residência.",
										"Promover queimadas afeta o meio ambiente e as pessoas que vivem ao "
										+ "seu redor. A fumaça é tóxica, pode causar problemas respiratórios e levar à morte de pessoas e animais. "
										+ "Além disso, a fumaça contém gases de efeito estufa, que afetam o meio ambiente local. Em alguma cidades, "
										+ "a prática é proibida e punível com multa. Fique atento, não promova mais queimadas.",
										new Consequencia("ficarSemJogar"), 52));
			
			listaEventos.add(new EventoImprevisto("Há recipientes desprotegidos com água parada na sua residência.",
										"Deixar recipientes desprotegidos com água parada é um grave risco à saúde pública. "
										+ "Esses recipientes são ótimos ambientes de reprodução do Aedes aegypti, mosquito "
										+ "transmisso da Dengue, Ziga e Chikungunya. Você está afetando não só a si, mas sua "
										+ "família e todos os seus vizinhos. Seja consciente, limpe seu quintal e receba periodicamente "
										+ "o Agente de Endemias para inspeção da sua casa. Una-se a luta contra o mosquito Aedes aegypti.",
										new Consequencia("voltarInicio"), 53));
			
			listaEventos.add(new EventoImprevisto("Você achou um filhote de Guaxinim e pensou que poderia levá-lo para casa.",
										"Animais silvestres podem transmitir uma série de doenças, como Febre Amarela e Raiva. Além disso, "
										+ "dependendo da espécie, esta ação pode ser ilegal, com prejuízo para todos os evolvidos. Se encontrar "
										+ "um animal silvestre, entregue-o às autoridades competentes.",
										new Consequencia("ficarSemJogar"), 54));
			
			listaEventos.add(new EventoImprevisto("Você jogou uma lata de refrigerante na rua.",
										"O lixo jogado em lugares indevidos pode servir de abrigo e alimento para animais e insetos que são vetores "
										+ "de doenças (como leptospirose, peste bubônica e tifo murino). Além disso, o lixo pode acumular estupir as "
										+ "galerias de água, contribuindo e potencializando as enchentes, destruindo casas e veículos, colocando a vida "
										+ "das pessoas em risco. Repense suas ações, não jogue lixo na rua.",
										new Consequencia("voltarInicio"), 55));
			
			listaEventos.add(new EventoImprevisto("Os produtos de limpeza que você utiliza impõe auto grau de contaminação do meio ambiente.",
										"Os custos de limpeza podem ser reduzidos ao optar por produtos biodegradáveis e receitas caseiras. Dessa forma,"
										+ "você participa do esforço coletivo de diminuir a poluição de rios e do impacto ambiental.",
										new Consequencia("voltar"), 56));
			
			listaEventos.add(new EventoImprevisto("Você comprou móveis feitos com madeira ilegal.",
										"Prefira madeira de reflorestamento ou certificada. Verifique a procedência de todo material feito de madeira "
										+ "e adquira produtos preferencialmente com selo de certificação FSC. Assim você ajuda as autoridades a combater"
										+ "a extração ilegal de madeira.",
										new Consequencia("ficarSemJogar"), 51));
			
//			listaEventos.add(new EventoImprevisto("", "", new Consequencia(""), 51));
			return listaEventos;
		}
		
	}

