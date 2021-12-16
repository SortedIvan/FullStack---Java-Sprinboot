import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
      })
      
    it("is possible to add games successfuly", ()=>{
        cy.visit("/games")
        cy.get("#gamecontainer").should("exist")

        /* ==== Generated with Cypress Studio ==== */
        cy.get('[href="/creategame"]').click();
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('testgame');
        cy.get(':nth-child(4) > .form-control').clear();
        cy.get(':nth-child(4) > .form-control').type('123');
        cy.get(':nth-child(6) > .form-control').clear();
        cy.get(':nth-child(6) > .form-control').type('123');
        cy.get(':nth-child(8) > .form-control').clear();
        cy.get(':nth-child(8) > .form-control').type('123');
        cy.get(':nth-child(10) > .form-control').clear();
        cy.get(':nth-child(10) > .form-control').type('123');
        cy.get(':nth-child(14) > .form-control').select('SinglePlayer');
        cy.get('form > .btn').click();
    })








})