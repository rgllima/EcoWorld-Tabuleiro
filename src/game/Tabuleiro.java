package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro {

		private Map<Integer, Evento> trilhas;
		private List<Evento> listaEventos;
		private List<Player> listaPlayers;
	
		public Tabuleiro(List<Player> listaPlayers) {
			trilhas = new HashMap<>();
			listaEventos = InicializarDados.getListaEventosPosisitvos();
			this.listaPlayers = listaPlayers;
			gerarTrilhas();
		}
		
		public void gerarTrilhas() {
		EventoPositivo evPsit = new EventoPositivo("","",new Consequencia(""), 1);
		Question evQest = new Question("", null, null, null, 2);
		EventoImprevisto evImp = new EventoImprevisto("","",new Consequencia(""), 3);
		trilhas.put(0, null);
	
		for (int i = 1; i<=63; i++) {
			if (i%11 == 0)
				trilhas.put(i, evPsit);
			else if (i%9 == 0)
				trilhas.put(i, evImp);
			else if (i%4 == 0)
				trilhas.put(i, evQest);
			else
				trilhas.put(i, null);
		}
		trilhas.put(64, null);
	}
		
		public void addListEvt(List<Evento> listaEventos) {
			this.listaEventos = listaEventos;
		}
	
		public boolean procuraEquivalenciaNome(Player player) {
			for (Player players : listaPlayers) {
				if (player.getName().equals(players.getName())) return true;
			}
			return false;
		}
	
		public boolean addPlayer(Player player) throws Exception{
			if (procuraEquivalenciaNome(player))
				throw new Exception("Nome do jogador já adicionado!");
			
			listaPlayers.add(player);
			return true;
		}
	
		public Player proximoPlayer(Player currentPlayer) {
			Player proximoPlayer = currentPlayer;
			
			if(listaPlayers.indexOf(currentPlayer) >= listaPlayers.size()-1)
				proximoPlayer =  listaPlayers.get(0);
			else
				proximoPlayer = listaPlayers.get(listaPlayers.indexOf(currentPlayer)+1);
			
			if (proximoPlayer.getPassaAVez()) {
				proximoPlayer.setPassaAVez(false);
				proximoPlayer = proximoPlayer(proximoPlayer);
			}
			
			return proximoPlayer;
			
		}
	
		//retorna o evento correspondente ao tipo de evento da trilha.
		public Evento getEvento(int position) {
			Evento eventoAux = getEventTrilha(position);
			for (Evento evento : listaEventos) {
				if (evento instanceof Question && eventoAux instanceof Question) {
					listaEventos.remove(evento);
					return evento;
				}
				else if (evento instanceof EventoImprevisto && eventoAux instanceof EventoImprevisto) {
					listaEventos.remove(evento);
					return evento;
				}
				else if (evento instanceof EventoPositivo && eventoAux instanceof EventoPositivo) {
					listaEventos.remove(evento);
					return evento;
				}
			}
			return null;
		}
	
		public List<Player> getListaPlayers(){
			return listaPlayers;
		}
	
		public int getSizeTrilhas() {
			return trilhas.size();
		}
	
		//retorna o evento específico de uma determinada trilha do tabuleiro
		private Evento getEventTrilha(int position) {
			return trilhas.get(position);
		}
	
		public List<Evento> getListaEventos() {
			return listaEventos;
		}


}
