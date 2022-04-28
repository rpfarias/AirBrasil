package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.TicketRequest;
import com.airbrasil.apirest.domain.request.TicketUpdateRequest;
import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.repository.RoleRepository;
import com.airbrasil.apirest.repository.TicketRepository;
import com.airbrasil.apirest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByUserId(Long userId) { return ticketRepository.findByUserId(userId); }

    public List<Ticket> ticketByCpf( String cpf) { return ticketRepository.findByCpf(cpf); }

    public List<Ticket> findByDestiny( String destiny) {
        return ticketRepository.findByDestiny(destiny);
    }

    public List<Ticket> findByOrigin( String origin) {
        return ticketRepository.findByOrigin(origin);
    }

    public List<Ticket> findAllByPassager( String passager) {
        return ticketRepository.findByPassager(passager);
    }

    public Ticket create( TicketRequest createRequest) {

//        BigDecimal valor;

        Ticket ticket = new Ticket();
        ticket.setPassager(createRequest.getPassager());
        ticket.setCpf(createRequest.getCpf());
        ticket.setOrigin(createRequest.getOrigin());
        ticket.setDestiny(createRequest.getDestiny());

        if (ticket.getOrigin().equals("Paris") && ticket.getDestiny().equals("Bogotá")) {
            ticket.setPrice(BigDecimal.valueOf(1100));
        } else if (ticket.getOrigin().equals("Krakovia") && ticket.getDestiny().equals("Gothan")) {
            ticket.setPrice(BigDecimal.valueOf(2150.10));
        } else if (ticket.getOrigin().equals("Paris") && ticket.getDestiny().equals("Gothan City")) {
            ticket.setPrice(BigDecimal.valueOf(5800.00));
        } else if (ticket.getOrigin().equals("Dublin") && ticket.getDestiny().equals("Bogotá")) {
            ticket.setPrice(BigDecimal.valueOf(3850.99));
        } else if (ticket.getOrigin().equals("Bankok") && ticket.getDestiny().equals("Salvador")) {
            ticket.setPrice(BigDecimal.valueOf(4690.99));
        } else if (ticket.getOrigin().equals("Rio de Janeiro") && ticket.getDestiny().equals("São Paulo")) {
            ticket.setPrice(BigDecimal.valueOf(350.99));
        } else if (ticket.getOrigin().equals("Salvador") && ticket.getDestiny().equals("São Paulo")) {
            ticket.setPrice(BigDecimal.valueOf(475.99));
        } else if (ticket.getOrigin().equals("Roma") && ticket.getDestiny().equals("Florianópolis")) {
            ticket.setPrice(BigDecimal.valueOf(2990.99));
        } else if (ticket.getOrigin().equals("Florianópolis") && ticket.getDestiny().equals("Roma")) {
            ticket.setPrice(BigDecimal.valueOf(2950.99));
        } else if (ticket.getOrigin().equals("Vitória") && ticket.getDestiny().equals("Goiânia")) {
            ticket.setPrice(BigDecimal.valueOf(220.99));
        } else if (ticket.getOrigin().equals("Recife") && ticket.getDestiny().equals("Porto Velho")) {
            ticket.setPrice(BigDecimal.valueOf(450.99));
        } else if (ticket.getOrigin().equals("Palmas") && ticket.getDestiny().equals("Boa Vista")) {
            ticket.setPrice(BigDecimal.valueOf(850.99));
        } else if (ticket.getOrigin().equals("Porto Alegre") && ticket.getDestiny().equals("Teresina")) {
            ticket.setPrice(BigDecimal.valueOf(280.99));
        } else if (ticket.getOrigin().equals("Belém") && ticket.getDestiny().equals("Recife")) {
            ticket.setPrice(BigDecimal.valueOf(350.99));
        } else if (ticket.getOrigin().equals("Campo Grande") && ticket.getDestiny().equals("Brasília")) {
            ticket.setPrice(BigDecimal.valueOf(150.99));
        } else if (ticket.getOrigin().equals("São Paulo") && ticket.getDestiny().equals("Salvador")) {
            ticket.setPrice(BigDecimal.valueOf(699.99));
        } else if (ticket.getOrigin().equals("São Paulo") && ticket.getDestiny().equals("Rio de Janeiro")) {
            ticket.setPrice(BigDecimal.valueOf(199.99));
        }


        ticket.setDataIda(createRequest.getDataIda());
        ticket.setDataVolta(createRequest.getDataVolta());
        ticket.setUserId(createRequest.getUserId());

        return ticketRepository.save(ticket);
    }

    public Ticket update(TicketUpdateRequest ticketUpdateRequest, Long id) {

        Ticket oldTicket = ticketRepository.getById(id);
        oldTicket.setPassager(ticketUpdateRequest.getPassager());
        oldTicket.setCpf(ticketUpdateRequest.getCpf());
        oldTicket.setOrigin(ticketUpdateRequest.getOrigin());
        oldTicket.setDestiny(ticketUpdateRequest.getDestiny());
        oldTicket.setPrice(ticketUpdateRequest.getPrice());
        oldTicket.setDataIda(ticketUpdateRequest.getDataIda());
        oldTicket.setDataVolta(ticketUpdateRequest.getDataVolta());
        oldTicket.setUserId(ticketUpdateRequest.getUserId());

        return ticketRepository.save(oldTicket);
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
