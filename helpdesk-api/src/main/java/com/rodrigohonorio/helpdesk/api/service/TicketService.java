package com.rodrigohonorio.helpdesk.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.rodrigohonorio.helpdesk.api.security.entity.ChangeStatus;
import com.rodrigohonorio.helpdesk.api.security.entity.Ticket;

@Component// para informar que essa classe sera gerenciada pelo Spring
public interface TicketService {
	// Cria ou faz update no ticjet
	Ticket createOrUpdate(Ticket ticket);
	//Procura o ticket
	Ticket findById(String id);
	// Deleta o ticket
	void delete(String id);
	//Passa a pagina e a quantidade de tickets
	Page<Ticket> listTicket(int page, int count);
	//Quarda as alterações de status no ticket
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	// Pesquisa de tickets alterados
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	// Para o clienete pesquisar somente os tickests dele
	Page<Ticket> findByCurrentUser(int page, int count, String userId);
	//Pesquisa tickets por parametrod
	Page<Ticket> findByParameters(int page, int count,String title,String status,String priority);
	//Pesquisa tickets por parametrod do usuario
	Page<Ticket> findByParametersAndCurrentUser(int page, int count,String title,String status,String priority,String userId);
	//Procura por id
	Page<Ticket> findByNumber(int page, int count,Integer number);
	//Resumo de todos os tickets
	Iterable<Ticket> findAll();
	//Quando o tecnico esta logado ele ve apenas os tickets atribuidos a ele
	public Page<Ticket> findByParametersAndAssignedUser(int page, int count,String title,String status,String priority,String assignedUserId);
}
