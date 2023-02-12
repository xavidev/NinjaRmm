package com.ninjaone.apps.rmmcustomers.controller;

import com.ninjaone.apps.rmmcustomers.CustomersApplicationTestCase;
import com.ninjaone.rmm.devices.application.create.CreateDeviceInformationCommand;
import com.ninjaone.rmm.services.application.create.CreateServiceInformationCommand;
import com.ninjaone.rmm.shared.domain.CustomerId;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public final class TechnicalTaskAcceptanceTest extends CustomersApplicationTestCase {

    private String customer;

    private String screenShareId = "322d91b8-441e-48f3-b223-ecc01eeb517d";
    private String backupId = "322d91b8-441e-48f3-b223-ecc01eeb517d";
    private String antivirusId = "322d91b8-441e-48f3-b223-ecc01eeb517d";
    private String windowsId = "c34512f7-631e-4200-b639-a973d4197e00";
    private String macId = "322d91b8-441e-48f3-b223-ecc01eeb517d";

    private String windowsFirstOrder = "5afab94a-a96b-4228-b373-a748dfdfd3e0";
    private String windowsSecondOrder = "365d0873-2f30-4b7f-9c78-bf375ef4f8a6";

    private String macFirstOrder = "7fbaba16-1f10-4558-b9e3-1d29dbcf790b";
    private String macSecondOrder = "08adc094-8138-41b8-bd68-578fc6f1666f";

    private String macThirdOrder = "766c1138-5caa-4539-a9b7-45f408674fbd";

    @BeforeEach
    void setUp() {
        customer = new CustomerId(UuidMother.random()).value();
        createWindows();
        createMac();
        createAntivirus();
        createBackup();
        createScreenShare();
    }

    private void createScreenShare() {
        givenISendCommandToTheBus(new CreateServiceInformationCommand(
            screenShareId,
            "Screen Share",
            "2"
        ));
    }

    private void createBackup() {
        givenISendCommandToTheBus(new CreateServiceInformationCommand(
            backupId,
            "Backup",
            "3"
        ));
    }

    private void createAntivirus() {
        givenISendCommandToTheBus(new CreateServiceInformationCommand(
            antivirusId,
            "Antivirus",
            "5"
        ));
    }

    private void createWindows() {
        givenISendCommandToTheBus(new CreateDeviceInformationCommand(
            windowsId,
            "Windows",
            "5"
        ));
    }

    private void createMac() {
        givenISendCommandToTheBus(new CreateDeviceInformationCommand(
            macId,
            "Mac",
            "5"
        ));
    }

    @Test
    void customer_with_2_Windows_and_3_Macs_with_the_following_services() throws Exception {
        withTwoWindowsWith(
            orderingAnAntivirus(),
            orderingAnAntivirus(),
            orderingABackup(),
            orderingAnScreenShare(),
            orderingAnScreenShare()
        );

        withThreeMacsWith(
            orderingAnAntivirus(),
            orderingAnAntivirus(),
            orderingAnAntivirus(),
            orderingABackup(),
            orderingABackup(),
            orderingAnScreenShare(),
            orderingAnScreenShare());

//
//        getTheExplanation(
//            """
//                Total Cost: $64
//                Explanation:
//                    Devices cost: $20
//                    Antivirus cost: $31
//                    Backup: $9
//                    Screen Share: $4
//                """
//        );
    }

    private void withTwoWindowsWith(Consumer<String>... orders) throws Exception {
        var deviceOrder = "{\"customerId\":\"" + customer + "\"}";
        assertRequestWithBody(
            "PUT",
            "/orders/" + windowsFirstOrder + "/devices/" + windowsId,
            deviceOrder,
            CREATED);

        for (Consumer<String> order : orders) {
            order.accept(windowsFirstOrder);
        }

        assertRequestWithBody(
            "PUT",
            "/orders/" + windowsSecondOrder + "/devices/" + windowsId,
            deviceOrder,
            CREATED);

        for (Consumer<String> order : orders) {
            order.accept(windowsSecondOrder);
        }
    }

    private void withThreeMacsWith(Consumer<String>... orders) throws Exception {
        var deviceOrder = "{\"customerId\":\"" + customer + "\"}";
        assertRequestWithBody(
            "PUT",
            "/orders/" + macFirstOrder + "/devices/" + macId,
            deviceOrder,
            CREATED);

        for (Consumer<String> order : orders) {
            order.accept(macFirstOrder);
        }

        assertRequestWithBody(
            "PUT",
            "/orders/" + macSecondOrder + "/devices/" + macId,
            deviceOrder,
            CREATED);

        for (Consumer<String> order : orders) {
            order.accept(macSecondOrder);
        }

        assertRequestWithBody(
            "PUT",
            "/orders/" + macThirdOrder + "/devices/" + macId,
            deviceOrder,
            CREATED);

        for (Consumer<String> order : orders) {
            order.accept(macThirdOrder);
        }
    }

    private Consumer<String> orderingABackup() {
        var request = "{\"deviceId\":\"" + windowsId + "\", \"customerId\":\"" + customer + "\"}";

        return (String orderId) -> {
            try {
                assertRequestWithBody(
                    "PUT",
                    "/orders/" + orderId + "/service/" + backupId,
                    request,
                    CREATED);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Consumer<String> orderingAnAntivirus() {
        var request = "{\"deviceId\":\"" + windowsId + "\", \"customerId\":\"" + customer + "\"}";

        return (String orderId) -> {
            try {
                assertRequestWithBody(
                    "PUT",
                    "/orders/" + orderId + "/service/" + antivirusId,
                    request,
                    CREATED);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Consumer<String> orderingAnScreenShare() {
        var request = "{\"deviceId\":\"" + windowsId + "\", \"customerId\":\"" + customer + "\"}";

        return (String orderId) -> {
            try {
                assertRequestWithBody(
                    "PUT",
                    "/orders/" + orderId + "/service/" + screenShareId,
                    request,
                    CREATED);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
