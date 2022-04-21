package fr.isika.cda14.efund.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.OrganizationInfo;
import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.account.UserInfo;
import fr.isika.cda14.efund.entity.common.Address;
import fr.isika.cda14.efund.entity.enums.AccountStatus;
import fr.isika.cda14.efund.entity.enums.Role;
import fr.isika.cda14.efund.entity.shop.Basket;
import fr.isika.cda14.efund.entity.shop.Shop;
import fr.isika.cda14.efund.entity.space.OrganizationSpace;
import fr.isika.cda14.efund.entity.space.UserSpace;
import fr.isika.cda14.efund.exception.UserAlreadyExistsException;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.tool.EmailTool;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@Stateless
public class AccountService {

	@Inject
	private AccountRepository repo;

	public OrganizationAccount createOrg(OrganizationForm inputOrg) {

		OrganizationAccount org = new OrganizationAccount();

		org.setEmail(inputOrg.getEmail());
		org.setPassword(inputOrg.getPassword());
		org.setDisplayedName(inputOrg.getDisplayedName());
		org.setOrganizationInfo(new OrganizationInfo());
		org.setOrganizationSpace(new OrganizationSpace());
		org.getOrganizationSpace().setShop(new Shop());
		org.setRole(Role.ASSOC);
		org.setAccountStatus(AccountStatus.ACTIVE);
		org.setImagePath("/img/organization/default.jpg");
		org.setCreationDate(new Date());
		return repo.persist(org);
	}

	public void updateOrg(Long id, OrganizationForm inputOrg) {

		OrganizationAccount org = repo.findOrganization(id);

		org.getOrganizationInfo().setName(inputOrg.getOrganizationName());
		org.getOrganizationInfo().setSiret(inputOrg.getSiret());
		org.getOrganizationInfo().setSummary(inputOrg.getSummary());
		org.getOrganizationInfo().setDescription(inputOrg.getDescription());
		if (inputOrg.getImagePath() != null) {
			org.setImagePath(inputOrg.getImagePath());
		}

		repo.update(org);
	}
	
	public void updateOrg(OrganizationAccount org) {
		repo.updateOrg(org);		
	}

	public UserAccount createUser(CreateUserViewModel inputUser) throws UserAlreadyExistsException {
		Optional<Account> account = repo.findByEmail(inputUser.getEmail());
		if (account.isPresent()) {
			throw new UserAlreadyExistsException("Le compte d'utilisateur existe déjà");
		}

		UserAccount user = new UserAccount();

		user.setEmail(inputUser.getEmail());
		user.setPassword(inputUser.getPassword());
		user.setDisplayedName(inputUser.getDisplayedName());
		user.setUserInfo(new UserInfo());
		user.getUserInfo().setUserAddress(new Address());
		user.setUserSpace(new UserSpace());
		user.setBasket(new Basket());
		user.setRole(Role.USER);
		user.setAccountStatus(AccountStatus.ACTIVE);
		user.setImagePath("defaultImg.jpg");

		return repo.persist(user);

	}

	public void updateUser(Long id, CreateUserViewModel inputUser) {
		UserAccount user = repo.findUser(id);

		user.getUserInfo().setFirstName(inputUser.getFirstName());
		user.getUserInfo().setLastName(inputUser.getLastName());
		user.getUserInfo().setPhone(inputUser.getPhone());
		user.getUserInfo().getUserAddress().setAddress(inputUser.getAddress());
		user.getUserInfo().getUserAddress().setCity(inputUser.getCity());
		user.getUserInfo().getUserAddress().setZipcode(inputUser.getZipcode());
		user.getUserInfo().getUserAddress().setCountry(inputUser.getCountry());

		repo.update(user);
	}

	/* UserAccount already ready for em.merge() */
	public void updateUser(UserAccount newValue) {
		repo.update(newValue);
	}

	public Optional<Account> findByEmail(String email) {
		return repo.findByEmail(email);
	}

	// pour trouver ma liste d'orga
	public List<OrganizationAccount> findAll() {
		return repo.findAll();
	}

	public Long getOrgSpaceId(Long id) {
		return repo.findOrgSpace(id).getId();
	}

	// pour trouver mon orga
	public OrganizationAccount findOrganizationAccount(Long id) {
		return repo.findOrganization(id);
	}

	public OrganizationAccount loadOrganizationAccountWithChildren(Long id) {
		return repo.loadOrganizationAccountWithChildren(id);
	}

	public List<UserAccount> getAllUsers() {
		return repo.getAllUsers();
	}

	public List<OrganizationAccount> getAllOrgs() {
		return repo.getAllOrgs();
	}

	public void deleteUser(Long id) {
		UserAccount user = repo.findUser(id);
		repo.removeUser(user);
	}

	public UserAccount findUserAccountById(Long id) {
		return repo.findUser(id);
	}

	public List<OrganizationAccount> getTopOrgs() {
		return repo.getTopOrgs();
	}
}
