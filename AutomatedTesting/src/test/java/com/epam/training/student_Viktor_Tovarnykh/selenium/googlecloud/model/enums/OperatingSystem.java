package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum OperatingSystem {

    FREE_PLAN("Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)", false),
    UBUNTU_PRO("Ubuntu Pro", true),
    WINDOWS_SERVER("Paid: Windows Server 2012 R2, Windows Server 2016, Windows Server 2019, Windows Server (2004, 20H2)", true),
    RED_HAT("Red Hat Enterprise Linux", true),
    RED_HAT_ENTERPRISE("Red Hat Enterprise Linux for SAP with HA and Update Services", true),
    SLES("SLES", true),
    SLES_12("SLES 12 for SAP", true),
    SLES_15("SLES 15 for SAP", true),
    SQL_SERVER("SQL Server Standard (2012, 2014, 2016, 2017, 2019)", true),
    SQL_SERVER_WEB("SQL Server Web (2012, 2014, 2016, 2017, 2019)", true),
    SQL_SERVER_ENTERPRISE("SQL Server Enterprise (2012, 2014, 2016, 2017, 2019)", true);

    private final String planName;
    private final boolean paidPlan;

    OperatingSystem(String planName, boolean paidPlan) {
        this.paidPlan = paidPlan;
        this.planName = planName;
    }

    public String getPlanName() {
        if (paidPlan) {
            return "Paid: " + planName;
        } else {
            return "Free: " + planName;
        }
    }

    public boolean isPaidPlan() {
        return paidPlan;
    }
}
