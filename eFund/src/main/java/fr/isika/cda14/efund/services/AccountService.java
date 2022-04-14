package fr.isika.cda14.efund.services;

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
import fr.isika.cda14.efund.repositories.OrganizationAccountRepo;
import fr.isika.cda14.efund.repositories.UserAccountRepository;
import fr.isika.cda14.efund.viewmodel.CreateUserBisViewModel;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@Stateless
public class AccountService {

	@Inject
	private OrganizationAccountRepo orgRepo;

	@Inject
	private UserAccountRepository userRepo;

	public Long createOrg(OrganizationForm inputOrg) {

		OrganizationAccount newOrg = new OrganizationAccount();

		newOrg.setEmail(inputOrg.getEmail());
		newOrg.setPassword(inputOrg.getPassword());
		newOrg.setDisplayedName(inputOrg.getDisplayedName());
		newOrg.setOrganizationInfo(new OrganizationInfo());
		newOrg.setOrganizationSpace(new OrganizationSpace());
		newOrg.getOrganizationSpace().setShop(new Shop());
		newOrg.setRole(Role.ASSOC);
		newOrg.setAccountStatus(AccountStatus.ACTIVE);
		newOrg.setImagePath("defaultImg.jpg");
		return orgRepo.persists(newOrg);
	}

	public void updateOrg(Long id, OrganizationForm inputOrg) {

		OrganizationAccount myOrg = orgRepo.find(id);

		myOrg.getOrganizationInfo().setName(inputOrg.getOrganizationName());
		myOrg.getOrganizationInfo().setSiret(inputOrg.getSiret());
		myOrg.getOrganizationInfo().setSummary(inputOrg.getSummary());
		myOrg.getOrganizationInfo().setDescription(inputOrg.getDescription());

		orgRepo.update(myOrg);
	}

	public Long createUser(CreateUserViewModel createUser) {

		UserAccount newUser = new UserAccount();

		newUser.setEmail(createUser.getEmail());
		newUser.setPassword(createUser.getPassword());
		newUser.setDisplayedName(createUser.getDisplayedName());
		newUser.setUserInfo(new UserInfo());
		newUser.getUserInfo().setUserAddress(new Address());
		newUser.setUserSpace(new UserSpace());
		newUser.setBasket(new Basket());
		newUser.setRole(Role.USER);
		newUser.setAccountStatus(AccountStatus.ACTIVE);
		newUser.setImagePath("defaultImg.jpg");

		return userRepo.persists(newUser);

	}

	public void updateUser(Long id, CreateUserBisViewModel createUserBis) {

		UserAccount user = userRepo.find(id);

		user.getUserInfo().setFirstName(createUserBis.getFirstName());
		user.getUserInfo().setLastName(createUserBis.getLastName());
		user.getUserInfo().setPhone(createUserBis.getPhone());
		user.getUserInfo().getUserAddress().setAddress(createUserBis.getAddress());
		user.getUserInfo().getUserAddress().setCity(createUserBis.getCity());
		user.getUserInfo().getUserAddress().setZipcode(createUserBis.getZipcode());
		user.getUserInfo().getUserAddress().setCountry(createUserBis.getCountry());

		userRepo.update(user);

	}

	public Optional<Account> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
