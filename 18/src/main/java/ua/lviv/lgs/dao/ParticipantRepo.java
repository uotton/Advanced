package ua.lviv.lgs.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {
	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Name1");
		participant1.setEmail("Name1@email.com");
		participant1.setPrimarySkill("skill1");
		participant1.setLevel(Level.L2);

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Name2");
		participant2.setEmail("Name2@email.com");
		participant2.setPrimarySkill("skill2");
		participant2.setLevel(Level.L1);

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Name3");
		participant3.setEmail("Name3@email.com");
		participant3.setPrimarySkill("skill3");
		participant3.setLevel(Level.L5);


		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);

	}

	public List<Participant> findAll() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int index = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(index, participantToUpdate);
		} else {
			participant.setId(participants.stream().mapToInt(p -> p.getId()).max().getAsInt() + 1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iterator = participants.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}
		}
	}
}