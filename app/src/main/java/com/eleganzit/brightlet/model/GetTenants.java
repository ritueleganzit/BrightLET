package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 5/23/2018.
 */

public class GetTenants
{
    String tenant_id,tenant_name,tenant_profile_image,tenant_initials,contract_id,property_id,decoded_property_id,property_rent,property_payment,renewal_date,renew_tenancy,agent_confirmed,tenant_confirmed,filename,has_rent_collect,rent_setup,has_deposit,paid_deposit,tenancy_finished,tenancy_type,tenancy_type_label,property_details;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public String getTenant_profile_image() {
        return tenant_profile_image;
    }

    public void setTenant_profile_image(String tenant_profile_image) {
        this.tenant_profile_image = tenant_profile_image;
    }

    public String getTenant_initials() {
        return tenant_initials;
    }

    public void setTenant_initials(String tenant_initials) {
        this.tenant_initials = tenant_initials;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getDecoded_property_id() {
        return decoded_property_id;
    }

    public void setDecoded_property_id(String decoded_property_id) {
        this.decoded_property_id = decoded_property_id;
    }

    public String getProperty_rent() {
        return property_rent;
    }

    public void setProperty_rent(String property_rent) {
        this.property_rent = property_rent;
    }

    public String getProperty_payment() {
        return property_payment;
    }

    public void setProperty_payment(String property_payment) {
        this.property_payment = property_payment;
    }

    public String getRenewal_date() {
        return renewal_date;
    }

    public void setRenewal_date(String renewal_date) {
        this.renewal_date = renewal_date;
    }

    public String getRenew_tenancy() {
        return renew_tenancy;
    }

    public void setRenew_tenancy(String renew_tenancy) {
        this.renew_tenancy = renew_tenancy;
    }

    public String getAgent_confirmed() {
        return agent_confirmed;
    }

    public void setAgent_confirmed(String agent_confirmed) {
        this.agent_confirmed = agent_confirmed;
    }

    public String getTenant_confirmed() {
        return tenant_confirmed;
    }

    public void setTenant_confirmed(String tenant_confirmed) {
        this.tenant_confirmed = tenant_confirmed;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getHas_rent_collect() {
        return has_rent_collect;
    }

    public void setHas_rent_collect(String has_rent_collect) {
        this.has_rent_collect = has_rent_collect;
    }

    public String getRent_setup() {
        return rent_setup;
    }

    public void setRent_setup(String rent_setup) {
        this.rent_setup = rent_setup;
    }

    public String getHas_deposit() {
        return has_deposit;
    }

    public void setHas_deposit(String has_deposit) {
        this.has_deposit = has_deposit;
    }

    public String getPaid_deposit() {
        return paid_deposit;
    }

    public void setPaid_deposit(String paid_deposit) {
        this.paid_deposit = paid_deposit;
    }

    public String getTenancy_finished() {
        return tenancy_finished;
    }

    public void setTenancy_finished(String tenancy_finished) {
        this.tenancy_finished = tenancy_finished;
    }

    public String getTenancy_type() {
        return tenancy_type;
    }

    public void setTenancy_type(String tenancy_type) {
        this.tenancy_type = tenancy_type;
    }

    public String getTenancy_type_label() {
        return tenancy_type_label;
    }

    public void setTenancy_type_label(String tenancy_type_label) {
        this.tenancy_type_label = tenancy_type_label;
    }

    public String getProperty_details() {
        return property_details;
    }

    public void setProperty_details(String property_details) {
        this.property_details = property_details;
    }

    public GetTenants(String tenant_id, String tenant_name, String tenant_profile_image, String tenant_initials, String contract_id, String property_id, String decoded_property_id, String property_rent, String property_payment, String renewal_date, String renew_tenancy, String agent_confirmed, String tenant_confirmed, String filename, String has_rent_collect, String rent_setup, String has_deposit, String paid_deposit, String tenancy_finished, String tenancy_type, String tenancy_type_label, String property_details) {
        this.tenant_id = tenant_id;
        this.tenant_name = tenant_name;
        this.tenant_profile_image = tenant_profile_image;
        this.tenant_initials = tenant_initials;
        this.contract_id = contract_id;
        this.property_id = property_id;
        this.decoded_property_id = decoded_property_id;
        this.property_rent = property_rent;
        this.property_payment = property_payment;
        this.renewal_date = renewal_date;
        this.renew_tenancy = renew_tenancy;
        this.agent_confirmed = agent_confirmed;
        this.tenant_confirmed = tenant_confirmed;
        this.filename = filename;
        this.has_rent_collect = has_rent_collect;
        this.rent_setup = rent_setup;
        this.has_deposit = has_deposit;
        this.paid_deposit = paid_deposit;
        this.tenancy_finished = tenancy_finished;
        this.tenancy_type = tenancy_type;
        this.tenancy_type_label = tenancy_type_label;
        this.property_details = property_details;
    }
}
