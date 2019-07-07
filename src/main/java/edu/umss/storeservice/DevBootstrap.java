/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.model.*;
import edu.umss.storeservice.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.sql.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryService categoryService;
    private ContractService contractService;
    private EmployeeService employeeService;
    private ExpenseService expenseService;
    private FeatureInstanceService featureInstanceService;
    private FeatureService featureService;
    private ItemInstanceService itemInstanceService;
    private ItemService itemService;
    private PositionService positionService;
    private SaleService saleService;
    private SubCategoryService subCategoryService;
    private ClientService clientService;
    private PromotionsService promotionsService;


    public DevBootstrap(ClientService clientService,CategoryService categoryService, ContractService contractService,
                        EmployeeService employeeService, ExpenseService expenseService,
                        FeatureInstanceService featureInstanceService, FeatureService featureService,
                        ItemInstanceService itemInstanceService, ItemService itemService, PositionService positionService,
                        SaleService saleService, SubCategoryService subCategoryService, PromotionsService promotionsService) {
        this.categoryService = categoryService;
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.expenseService = expenseService;
        this.featureInstanceService = featureInstanceService;
        this.featureService = featureService;
        this.itemInstanceService = itemInstanceService;
        this.itemService = itemService;
        this.positionService = positionService;
        this.saleService = saleService;
        this.subCategoryService = subCategoryService;
        this.clientService = clientService;
        this.promotionsService = promotionsService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Adding clients
        Client clientlist=new Client();
        clientlist.setFirstNameClient("juan");
        clientlist.setLastNameClient("Perez");
        clientlist.setEmailClient("juanperes@gmail.com");
        clientlist.setNitClient(45547554);
        clientlist.setNumberTelephoneC("455477");
        clientlist.setCiClient(456888);
        clientService.save(clientlist);

        Client clientlist2=new Client();
        clientlist2.setFirstNameClient("juan2");
        clientlist2.setLastNameClient("Perez2");
        clientlist2.setEmailClient("juanperes2@gmail.com");
        clientlist2.setNitClient(457554);
        clientlist2.setNumberTelephoneC("89455477");
        clientlist2.setCiClient(99438798);
        clientService.save(clientlist2);

        //Adding promotions
        Promotions promotion1 = new Promotions();
        promotion1.setNamePromotion("Promocion camioneta mitad de precio");
        promotion1.setDiscountPromotion(50);
        Calendar calendarBegin = Calendar.getInstance();
        calendarBegin.set(2019, Calendar.AUGUST, 10);
        Date dateBegin1 = new Date(calendarBegin.getTimeInMillis());
        promotion1.setStartproDatePro(dateBegin1);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.set(2019, Calendar.SEPTEMBER, 10);
        Date dateBegin2 = new Date(calendarEnd.getTimeInMillis());
        promotion1.setExpiredproDatePro(dateBegin2);
        promotionsService.save(promotion1);

        Promotions promotion2 = new Promotions();
        promotion2.setNamePromotion("Promocion 20% de descuento");
        promotion2.setDiscountPromotion(20);
        Calendar calendarBeginA = Calendar.getInstance();
        calendarBeginA.set(2019, Calendar.NOVEMBER, 23);
        Date dateBeginA = new Date(calendarBeginA.getTimeInMillis());
        promotion2.setStartproDatePro(dateBeginA);

        Calendar calendarEnd2 = Calendar.getInstance();
        calendarEnd2.set(2019, Calendar.DECEMBER, 25);
        Date dateBeginB = new Date(calendarEnd2.getTimeInMillis());
        promotion2.setExpiredproDatePro(dateBeginB);
        promotionsService.save(promotion2);

        // MAQUINARIA category
        Category maquinariaCategory = new Category();
        maquinariaCategory.setCode("MAQ");
        maquinariaCategory.setName("MAQUINARIA");
        categoryService.save(maquinariaCategory);

        // TRACTOR subcategory
        SubCategory tractorSubCategory = new SubCategory();
        tractorSubCategory.setCategory(maquinariaCategory);
        tractorSubCategory.setCode("TRA");
        tractorSubCategory.setName("TRACTOR");
        subCategoryService.save(tractorSubCategory);

        // Taller category
        Category tallerCategory = new Category();
        tallerCategory.setCode("TAL");
        tallerCategory.setName("TALLER");
        categoryService.save(tallerCategory);


        // montacarga subcategory
        SubCategory montacargaSubCategory = new SubCategory();
        montacargaSubCategory.setCategory(maquinariaCategory);
        montacargaSubCategory.setCode("MON");
        montacargaSubCategory.setName("MONTACARGA");
        subCategoryService.save(montacargaSubCategory);

        // tractorKubota20 Item
        Item tractorKubota20 = new Item();
        tractorKubota20.setCode("TRACTOR-K-20");
        tractorKubota20.setName("TRACTOR Kubota 20 HP");
        tractorKubota20.setSubCategory(tractorSubCategory);
        itemService.save(tractorKubota20);

        // montacargaMitsubishi2T Item
        Item montacargaMitsubishi2T = new Item();
        montacargaMitsubishi2T.setCode("MON-M-2T");
        montacargaMitsubishi2T.setName("MONTACARGA MITSUBISHI 2T");
        montacargaMitsubishi2T.setSubCategory(montacargaSubCategory);
        itemService.save(montacargaMitsubishi2T);

        // Employee Employee
        Employee john = new Employee();
        john.setFirstName("Pepito");
        john.setLastName("Perez");

        // Position
        Position position = new Position();
        position.setName("CHAPERO");
        positionService.save(position);

        // contract
        Contract contract = new Contract();
        contract.setEmployee(john);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.MARCH, 10);
        contract.setInitDate(calendar.getTime());
        contract.setPosition(position);

        john.getContracts().add(contract);
        employeeService.save(john);
        //contractService.save(contract);
    }

}
