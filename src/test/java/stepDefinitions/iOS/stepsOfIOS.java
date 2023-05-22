package stepDefinitions.iOS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static support.World.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import java.io.IOException;

public class stepsOfIOS {

    @Given("User click on first menu of virdee")
    public void user_click_on_first_menu_of_virdee() {
       objRegister1.enterSSNNumber();
    }

    @Given("user click on checkIn menu")
    public void userClickOnCheckInMenu() {
        objRegister1.checkIn();
    }

    @And("select login using name")
    public void selectLoginUsingName() {
        objRegister1.selectLoginByUsingName();
    }

    @And("user enter {string} and {string}")
    public void userEnterAnd(String firstname, String lastname) throws InterruptedException {
        objRegister1.enterFirstNameAndLastName(firstname,lastname);
    }

    @And("click on continue button")
    public void clickOnContinueButton() throws InterruptedException {
        objRegister1.hideKeyboard();
        objRegister1.clickOnContinue();
    }

    @Then("user should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
    }

    @And("user should be able to tap on phone number displayed on screen")
    public void userShouldBeAbleToTapOnPhoneNumberDisplayedOnScreen() throws InterruptedException {
      objRegister1.clickOnPhoneNumberFieldAndWaitForOtp();
    }

    @And("validate after entering OTP")
    public void validateAfterEnteringOTP() throws InterruptedException, IOException {
        objRegister1.hideKeyboard();
        objRegister1.waitTillOtpEnterAndClickOnValidate();
        objRegister1.verifyIfReservationCreated();
    }


    @When("user select login using mobile number")
    public void userSelectLoginUsingMobileNumber() {
        objRegister1.selectPhoneNumberToContinue();
    }

    @When("user select login using confirmation number")
    public void userSelectLoginUsingConfirmationNumber() {
        objRegister1.selectCheckInUsingConfirmationNumber();
    }

    @And("click on continue after entering valid {string} and {string}")
    public void clickOnContinueAfterEnteringValid(String confirmationNumber, String lastName) {

    }

    @Then("user should be successfully checkIn")
    public void userShouldBeSuccessfullyCheckIn() throws InterruptedException {
      objRegister1.clickOnPhoneNumberFieldAndWaitForOtp();
    }

    @And("navigate back to home screen")
    public void navigateBackToHomeScreen() {
        objRegister1.navigateBackToHome();
    }

    @And("click on continue after entering valid {string}")
    public void clickOnContinueAfterEnteringValid(String mobileNumber) throws InterruptedException {
        objRegister1.clickOnContinueAfterEnteringMobileNumber(mobileNumber);
        objRegister1.hideKeyboard();
        objRegister1.clickOnContinue();
    }

    @And("click on continue after entering valid  confirmation number {string}")
    public void clickOnContinueAfterEnteringValidConfirmationNumber(String confirmationNumber,String lastName) throws InterruptedException {
        objRegister1.fillConfirmationNumberDetails(confirmationNumber,lastName);
        objRegister1.hideKeyboard();
        objRegister1.clickOnContinue();
        objRegister1.verifyIfReservationCreated();
    }


    @When("user select login using email address")
    public void userSelectLoginUsingEmailAddress() {
       objRegister1.selectLoginByUsingEmailAddress();
    }

    @And("click on continue after entering valid emailAddress {string}")
    public void clickOnContinueAfterEnteringValidEmailAddress(String emailAddress) throws InterruptedException {
        objRegister1.clickOnContinueAfterEnteringEmailAddress(emailAddress);
        objRegister1.hideKeyboard();
        objRegister1.clickOnContinue();
    }

    @When("user select login using QR Code")
    public void userSelectLoginUsingQRCode() {
        objRegister1.selectQRCodeFromMenus();
    }

    @Then("wait for scanning")
    public void waitForScanning() throws InterruptedException {
        Thread.sleep(10000);
    }

    @When("select using name and departure date")
    public void selectUsingNameAndDepartureDate() {
    objRegister1.selectUsingDepartureDate();
    }

    @And("enter valid {string} and {string}")
    public void enterValidAnd(String firstName, String lastName) throws InterruptedException {
        objRegister1.enterFirstNameAndLastNameForDepartureFunctionality(firstName,lastName);
    }


    @And("select departure date {string}")
    public void selectDepartureDate(String departureDate) throws InterruptedException {
        objRegister1.selectDepartureDate(departureDate);
        System.out.println("date selected");
        objRegister1.verifyIfReservationCreated();
    }

    @And("select email proceed for departure")
    public void selectEmailProceedForDeparture() throws InterruptedException {
        objRegister1.emailProceedDeparture();
        objRegister1.getOTPFromMailinator();
    }

    @And("validate it after entering OTP for mobile number")
    public void validateItAfterEnteringOTPForMobileNumber() throws InterruptedException {
        objRegister1.hideKeyboard();
//        objRegister1.waitTillMobileOtpEnterAndClickOnValidate();
        objRegister1.verifyIfReservationCreated();

    }

    @Given("user select want to talk someone link")
    public void userSelectWantToTalkSomeoneLink() throws InterruptedException {
        objRegister1.clickOnWantToTalkLink();
    }

    @And("select Video call option")
    public void selectVideoCallOption() {
        objRegister1.selectVideoCallOption();
    }

    @And("user end the Video call")
    public void userEndTheVideoCall() {
        objRegister1.clickOnEndCall();
        objRegister1.verifyConfirmationPopupAndClickOnYes();
    }

    @Then("user should see video call option")
    public void userShouldSeeVideoCallOption() {
        objRegister1.verifyCallingChoosePage();
    }

    @And("select audio call option")
    public void selectAudioCallOption() {
        objRegister1.selectAudioCallOption();
    }

    @Then("user should see audio call option")
    public void userShouldSeeAudioCallOption() {
        objRegister1.verifyCallingChoosePage();
    }

    @And("user end the audio call")
    public void userEndTheAudioCall() {
        objRegister1.clickOnEndCall();
        objRegister1.verifyConfirmationPopupAndClickOnYes();
    }

    @And("navigate back After scanning QR code")
    public void navigateBackAfterScanningQRCode() throws InterruptedException {
        objRegister1.backToHome();
    }

    @And("validate it after entering OTP for mobile number {string}")
    public void validateItAfterEnteringOTPForMobileNumber(String mobileNumberForOTP) throws InterruptedException, IOException {
        objRegister1.hideKeyboard();
        objRegister1.getOTPForMobileNumber(mobileNumberForOTP);
    }

    @And("validate after entering OTP for")
    public void validateAfterEnteringOTPFor() throws InterruptedException, IOException {
        objRegister1.hideKeyboard();
        objRegister1.waitTillOtpEnterAndClickOnValidate();
        objRegister1.verifyIfReservationCreated();
    }

    @And("validate after entering OTP for emailAddress")
    public void validateAfterEnteringOTPForEmailAddress() throws IOException, InterruptedException {
        objRegister1.hideKeyboard();
        objRegister1.getOTPFromMailinator();
        objRegister1.waitTillOtpForEmailEnterAndClickOnValidate();
        objRegister1.verifyIfReservationCreated();
    }

    @And("navigate to get card and end session")
    public void navigateToGetCardAndEndSession() throws InterruptedException {
        objRegister1.clickOnReservation();
        objRegister1.validateAllThings();


    }

    @And("click on continue after entering valid  confirmation number {string}  and {string}")
    public void clickOnContinueAfterEnteringValidConfirmationNumberAnd(String confirmationNumber, String lastName) throws InterruptedException {
        objRegister1.fillConfirmationNumberDetails(confirmationNumber,lastName);
        objRegister1.hideKeyboard();
        objRegister1.clickOnContinue();
//        objRegister1.verifyIfReservationCreated();

    }

    @When("user select setting icon")
    public void userSelectSettingIcon() {
        objRegister1.clickOnSettingsIcon();
    }

    @And("user enter {string} and submit it")
    public void userEnterAndSubmitIt(String password) throws InterruptedException {
        objRegister1.enterPasswordAndSubmit(password);
    }

    @SneakyThrows
    @And("select reservation")
    public void selectReservation() {
        objRegister1.clickOnReservation();
    }

    @Then("validate signature after click on continue button")
    public void validateSignatureAfterClickOnContinueButton() {
        objRegister1.validateSignature();
    }

    @And("select edit user details")
    public void selectEditUserDetails() {
        objRegister1.clickOnEditButton();
    }



    @And("edit {string} and update details {string}")
    public void editAndUpdateDetails(String newUserName, String lastName) throws InterruptedException {
        objRegister1.editUserDetailsAndUpdateDetails(newUserName,lastName);
    }

//    @When("user go to My Account > Account Statement > Transaction history")
//    public void user_go_to_My_Account_Account_Statement_Transaction_history() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToTransactionHistory();
//    }
//
//    @When("user go to My Account > Account Statement > Gaming Limit History")
//    public void user_go_to_My_Account_Account_Statement_Gaming_Limit_History() {
////        objGamingLimitScreen.menuBackButton();
//        objTransactionHistoryScreen.navigateToGamingLimitHistory();
//    }
//    @When("user navigate to My Account > Account Statement > Gaming Limit History")
//    public void user_navigate_to_My_Account_Account_Statement_Gaming_Limit_History() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToGamingLimitHistory();
//    }
//    @When("navigate to My Account > Account Statement > Gaming Limit History")
//    public void navigate_to_My_Account_Account_Statement_Gaming_Limit_History() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateGamingLimitHistory();
//    }
//
//    @When("select transaction type game play from dropdown")
//    public void select_transaction_type_game_play_from_dropdown() {
//        objTransactionHistoryScreen.transactionTypeGamePlay();
//    }
//
//    @When("check wager info timestamp game title wager amount balance")
//    public void check_wager_info_timestamp_game_title_wager_amount_balance() {
//        objTransactionHistoryScreen.expandWagerInfo();
//    }
//
//    @When("check wager details section by expanding wager info")
//    public void check_wager_details_section_by_expanding_wager_info() {
//        objTransactionHistoryScreen.verifyWagerInfo();
//    }
//
//    @Then("For full details please contact Customer Services message is displayed")
//    public void for_full_details_please_contact_Customer_Services_message_is_displayed() {
//        objTransactionHistoryScreen.verifyWagerInfoFullDetailsServiceMessage();
//    }
//
//    @Then("The gaming limits history shows accurately the gaming limits imposed by the customer")
//    public void the_gaming_limits_history_shows_accurately_the_gaming_limits_imposed_by_the_customer() {
//        objTransactionHistoryScreen.verifyGamingHistoryInAccountStatement();
//    }
//
//    @When("user go to My Account > Account Statement > Win Loss")
//    public void user_go_to_My_Account_Account_Statement_Win_Loss() {
//        objMyAccountMenusScreen.openMyAccountMenu();
////        objMyAccountMenusScreen.accountStatement();
//        objTransactionHistoryScreen.navigateToWinLoss();
//    }
//
//    @When("Select the Bonuses filter from the drop-down")
//    public void select_the_Bonuses_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypeBonuses();
//    }
//    @When("Bonus transaction should be visible")
//    public void Bonus_transaction_should_be_visible() {
//        objTransactionHistoryScreen.verifyLastBounsTransactionInfo();
//    }
//
//    @When("Only Bonus related transactions are displayed")
//    public void only_Bonus_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Payment filter from the drop-down")
//    public void select_the_Payment_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypePayment();
//    }
//
//    @When("Only Payments related transactions are displayed")
//    public void only_Payments_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Pending Withdrawals filter from the drop-down")
//    public void select_the_Pending_Withdrawals_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypePendingWithdrawal();
//    }
//
//    @When("Only Pending Withdrawals related transactions are displayed")
//    public void only_Pending_Withdrawals_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Adjustments filter from the drop-down")
//    public void select_the_Adjustments_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypeAdjustment();
//    }
//
//    @When("Only Cash Correction transactions are displayed")
//    public void only_Cash_Correction_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Tips filter from the drop-down")
//    public void select_the_Tips_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypeTips();
//    }
//
//    @When("Only Tips transactions are displayed")
//    public void only_Tips_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Gameplay filter from the dropdown")
//    public void select_the_Gameplay_filter_from_the_dropdown() {
//        objTransactionHistoryScreen.transactionTypeGamePlay();
//    }
//
//    @When("Only gameplay related transactions are displayed")
//    public void only_gameplay_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Sports Bets filter from the drop-down")
//    public void select_the_Sports_Bets_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypeSportsBet();
//    }
//
//    @When("Only Sports Bets related transactions are displayed")
//    public void only_Sports_Bets_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @When("Select the Rewards filter from the drop-down")
//    public void select_the_Rewards_filter_from_the_drop_down() {
//        objTransactionHistoryScreen.transactionTypeRewards();
//    }
//
//    @When("Only the Rewards related transactions are displayed")
//    public void only_the_Rewards_related_transactions_are_displayed() {
//        objTransactionHistoryScreen.verifyTransactionDisplayed();
//    }
//
//    @Then("All the filtering options should be works correctly in Transaction History")
//    public void all_the_filtering_options_should_be_works_correctly_in_Transaction_History() {
//    }
//
//    @When("Make a deposit for {string}")
//    public void make_a_deposit_for(String string) {
//
//    }
//    @When("Make a withdrawal for {string}")
//    public void make_a_withdrawal_for(String string) {
//
//    }
//    @When("Make a withdrawal for {string} via withdraw tab")
//    public void make_a_withdrawal_for_via_withdraw_tab(String string) {
//        objMyAccountMenusScreen.openMyAccountMenu();
//    }
//
//    @When("Go to transaction history in an account statement")
//    public void go_to_transaction_history_in_an_account_statement() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToTransactionHistory();
//    }
//
//    @When("Check first visible line")
//    public void check_first_visible_line() {
//        objTransactionHistoryScreen.expandFirstTransactionInfo();
//    }
//    @When("Check first line")
//    public void check_first_line() {
//        objTransactionHistoryScreen.expandFirstTransaction();
//    }
//    @Then("The first line should be my last deposit and all fields should match correct data")
//    public void the_first_line_should_be_my_last_deposit_and_all_fields_should_match_correct_data() {
//
//        objTransactionHistoryScreen.verifyLastDepositTransactionInfo();
//
//    }
//    @Then("The first line should be my withdrawal request and all fields should match correct data")
//    public void the_first_line_should_be_my_withdrawal_request_and_all_fields_should_match_correct_data() {
//
//        objTransactionHistoryScreen.verifyLastWithdrawalTransactionInfo();
//
//    }
//    @When("user go to gaming limits and change the daily deposit limit twice")
//    public void user_go_to_gaming_limits_and_change_the_daily_deposit_limit_twice() {
//
//    }
//
//    @When("navigate to limits history in an account statement")
//    public void navigate_to_limits_history_in_an_account_statement() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToGamingLimitHistory();
//    }
//
//    @When("user should see two changes made in preconditions as two separate records")
//    public void user_should_see_two_changes_made_in_preconditions_as_two_separate_records() {
//
//    }
//
//    @Then("Both should has dates and times are being displayed in format hh mm ss am pm mm dd yyyy")
//    public void both_should_has_dates_and_times_are_being_displayed_in_format_hh_mm_ss_a_m_p_m_mm_dd_yyyy() {
//        objTransactionHistoryScreen.verifyTimeAndDateIsDisplayInGamingHistoryInAccountStatement();
//    }
//
//    @Then("Description Daily Weekly Monthly Deposit Limit AMOUNT Correct limit set displayed with Currency notation in $X,XXX.XX format")
//    public void description_Daily_Weekly_Monthly_Deposit_Limit_AMOUNT_Correct_limit_set_displayed_with_Currency_notation_in_$X_XXX_XX_format() {
//        objTransactionHistoryScreen.verifyDailyDepositGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyWeeklyDepositGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyMonthlyDepositGamingHistoryInAccountStatement();
//    }
//
//    @When("user try to set or update Daily Weekly Spend limit from My Account > Responsible Gaming > Gaming limits")
//    public void user_try_to_set_or_update_Daily_Weekly_Spend_limit_from_My_Account_Responsible_Gaming_Gaming_limits() {
//
//    }
//    @When("user try to set or update Daily Weekly time limit from My Account > Responsible Gaming > Gaming limits")
//    public void user_try_to_set_or_update_Daily_Weekly_time_limit_from_My_Account_Responsible_Gaming_Gaming_limits() {
//
//    }
//
//    @When("user click on update limit after entering a value into daily weekly monthly spend limit {string} {string} {string}")
//    public void user_click_on_update_limit_after_entering_a_value_into_daily_weekly_monthly_spend_limit(String string, String string2, String string3) {
//
//    }
//    @When("user click on update limit after entering a value into daily weekly monthly time limit {string} {string} {string}")
//    public void user_click_on_update_limit_after_entering_a_value_into_daily_weekly_monthly_time_limit(String string, String string2, String string3) {
//
//    }
//
//
//    @Then("Description Daily Weekly Monthly Spend Limit AMOUNT Correct limit set displayed with Currency notation in $X,XXX.XX format")
//    public void description_Daily_Weekly_Monthly_Spend_Limit_AMOUNT_Correct_limit_set_displayed_with_Currency_notation_in_$X_XXX_XX_format() {
//        objTransactionHistoryScreen.verifyDailySpendGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyMonthlySpendGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyWeeklySpendGamingHistoryInAccountStatement();
//    }
//    @Then("Description Daily Weekly Monthly time Limit AMOUNT Correct limit set displayed with Time format hh mm")
//    public void description_Daily_Weekly_Monthly_time_Limit_AMOUNT_Correct_limit_set_displayed_with_Time_format_hh_mm() {
//        objTransactionHistoryScreen.verifyDailyTimeGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyWeeklyTimeGamingHistoryInAccountStatement();
//        objTransactionHistoryScreen.verifyMonthlyTimeGamingHistoryInAccountStatement();
//    }
//
//    @When("Open My Account Menu")
//    public void open_My_Account_Menu() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//
//    }
//
//    @When("Modal should be opened after clicking on Account Statement link")
//    public void modal_should_be_opened_after_clicking_on_Account_Statement_link() {
//        objMyAccountMenusScreen.accountStatement();
//    }
//
//    @Then("Header should read Account Statement")
//    public void header_should_read_Account_Statement() {
//        objMyAccountMenusScreen.accountStatementHeader();
//    }
//
//    @Then("Transaction History tab should be active")
//    public void transaction_History_tab_should_be_active() {
//
//        objAccountStatementScreen.transactionHistory();
//    }
//    @When("Click on Win Loss button")
//    public void click_on_Win_Loss_button() {
//      //  objMyAccountMenusScreen.openMyAccountMenu();
//        objAccountStatementScreen.clickOnwinloss();
//    }
//
//
//    @When("Modal and header should stay as they were with Win Loss active tab and the content of modal should change to Win Loss")
//    public void modal_and_header_should_stay_as_they_were_with_Win_Loss_active_tab_and_the_content_of_modal_should_change_to_Win_Loss() {
//
//    }
//
//    @When("Click on Gaming Limits history button")
//    public void click_on_Gaming_Limits_history_button() {
//        objAccountStatementScreen.clickOnGamingLimitsHistry();
//    }
//
//    @When("Modal and header should stay as they were with Gaming Limits history active tab and the content of modal should change to Gaming Limits history")
//    public void modal_and_header_should_stay_as_they_were_with_Gaming_Limits_history_active_tab_and_the_content_of_modal_should_change_to_Gaming_Limits_history() {
//
//    }
//
//    @When("Click on Tax forms button")
//    public void click_on_Tax_forms_button() {
//        objAccountStatementScreen.clickOnTaxForms();
//    }
//
//    @When("Modal and header should stay as they were with Tax forms active tab and the content of modal should change to Tax forms")
//    public void modal_and_header_should_stay_as_they_were_with_Tax_forms_active_tab_and_the_content_of_modal_should_change_to_Tax_forms() {
//
//    }
//
//    @When("Click on Bet history button")
//    public void click_on_Bet_history_button() {
//        objAccountStatementScreen.clickOnBetHistry();
//    }
//
//    @When("Modal and header should stay as they were with Bet history active tab and the content of modal should change to Bet history")
//    public void modal_and_header_should_stay_as_they_were_with_Bet_history_active_tab_and_the_content_of_modal_should_change_to_Bet_history() {
//
//    }
//
//    @When("Click on Transaction history button")
//    public void click_on_Transaction_history_button() {
//        objAccountStatementScreen.clickOnTrasactionHistry();
//    }
//
//    @Then("Modal and header should stay as they were with Transaction history tab should be active and the content of modal should change to Transaction history")
//    public void modal_and_header_should_stay_as_they_were_with_Transaction_history_tab_should_be_active_and_the_content_of_modal_should_change_to_Transaction_history() {
//
//    }
//
//    @Given("Login with the active account with valid {string} and {string} that made sportsbook bets")
//    public void login_with_the_active_account_with_valid_and_that_made_sportsbook_bets(String emailAddress, String password) {
//        objLoginscreen.clickOnLoginButton();
//        objLoginscreen.verifyLoginScreen();
//        objLoginscreen.enterEmailAddress(emailAddress);
//        objLoginscreen.enterPassword(password);
//        objLoginscreen.clickOnLoginSubmit();
//    }
//
//    @When("Open Account Statement")
//    public void open_Account_Statement() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToSportsBetHistory();
//    }
//
//    @When("Bets should be visible after Searching for bets with time period all")
//    public void bets_should_be_visible_after_Searching_for_bets_with_time_period_all() {
//        objLoginFromDemoPlayScreen.searchBetHistoryWithAll();
//        objLoginFromDemoPlayScreen.selectTimePeriodFromDropDownBetHistory();
//        objLoginFromDemoPlayScreen.verifyBetHistoryDisplayed();
//    }
//
//    @When("Scroll down the page")
//    public void scroll_down_the_page() {
//        objLoginFromDemoPlayScreen.scrollDownBetHistory();
//    }
//
//    @Then("Scroll should work without any issue")
//    public void scroll_should_work_without_any_issue() {
//
//    }
//    @When("User should see correct data in casino stakes results and Win Loss based on an amount of stake win or loss difference and Currency notation will support $X,XXX.XX format")
//    public void user_should_see_correct_data_in_casino_stakes_results_and_Win_Loss_based_on_an_amount_of_stake_win_or_loss_difference_and_Currency_notation_will_support_$X_XXX_XX_format() {
//        objLoginFromDemoPlayScreen.verifySportsBetWinLossStatement();
//    }
//
//    @When("User should see correct data in Sports and Total section stakes results and Win Loss based on an amount of stake win or loss difference and Currency notation will support $X,XXX.XX format")
//    public void user_should_see_correct_data_in_Sports_and_Total_section_stakes_results_and_Win_Loss_based_on_an_amount_of_stake_win_or_loss_difference_and_Currency_notation_will_support_$X_XXX_XX_format() {
//
//    }
//
//    @Then("Correct data should be visible in Total sections Sports + Casino")
//    public void correct_data_should_be_visible_in_Total_sections_Sports_Casino() {
//
//    }
//    @When("System print popup should be visible after Clicking on the Print button")
//    public void system_print_popup_should_be_visible_after_Clicking_on_the_Print_button() {
//        objLoginFromDemoPlayScreen.verifyPrintStatementWinLoss();
//    }
//
//    @When("See a preview of the print")
//    public void see_a_preview_of_the_print() {
//
//    }
//
//    @Then("The document should look decent and have the same data as account statement view")
//    public void the_document_should_look_decent_and_have_the_same_data_as_account_statement_view() {
//
//    }
//    @Then("Transaction History tab should be visible")
//    public void transaction_History_tab_should_be_visible() {
//        objTransactionHistoryScreen.verifyAccountStatementPage();
//    }
//    @When("user Navigate My Account > Account Statement > Transaction history")
//    public void user_navigate_My_Account_Account_Statement_Transaction_history() {
//       // objMyAccountMenusScreen.clickOnBackMenu();
//        objTransactionHistoryScreen.navigateToTransactionHistory();
//    }
//    @When("user Navigate to Account >  Account Statement > Transaction history")
//    public void user_Navigate_to_My_Account_Account_Statement_Transaction_history() {
//        objMyAccountMenusScreen.openMyAccountMenu();
//        objTransactionHistoryScreen.navigateToTransactionHistory();
//    }
}
