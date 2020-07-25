package ru.appline.framework.managers;

import ru.appline.framework.pages.ClientInfoInsuranceFormPage;
import ru.appline.framework.pages.ClientPage;
import ru.appline.framework.pages.InsuranceSumSelectionPage;
import ru.appline.framework.pages.TravelInsurancePage;

public class PagesManager {

    private static PagesManager pagesManager;

    ClientPage clientPage;

    TravelInsurancePage travelInsurancePage;

    InsuranceSumSelectionPage insuranceSumSelectionPage;

    ClientInfoInsuranceFormPage clientInfoInsuranceFormPage;

    private PagesManager() {
    }

    public static PagesManager getPagesManager() {
        if (pagesManager == null) {
            pagesManager = new PagesManager();
        }
        return pagesManager;
    }

    public ClientPage getClientPage() {
        if (clientPage == null) {
            clientPage = new ClientPage();
        }
        return clientPage;
    }

    public TravelInsurancePage getTravelInsurancePage() {
        if (travelInsurancePage == null) {
            travelInsurancePage = new TravelInsurancePage();
        }
        return travelInsurancePage;
    }

    public InsuranceSumSelectionPage getInsuranceSumSelectionPage() {
        if (insuranceSumSelectionPage == null) {
            insuranceSumSelectionPage = new InsuranceSumSelectionPage();
        }
        return insuranceSumSelectionPage;
    }

    public ClientInfoInsuranceFormPage getClientInfoInsuranceFormPage() {
        if (clientInfoInsuranceFormPage == null) {
            clientInfoInsuranceFormPage = new ClientInfoInsuranceFormPage();
        }
        return clientInfoInsuranceFormPage;
    }
}
