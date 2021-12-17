import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
        cy.saveLocalStorage();
      })

      beforeEach(() => {
        cy.restoreLocalStorage();
      });
      
    
    it("is possible to add games successfuly", ()=>{
        cy.visit("/games")
        cy.get("#gamecontainer").should("exist")
        cy.get('#createGame').click();
        cy.get('#gameName').clear();
        cy.get('#gameName').type('TestGame');
        cy.get('#gameSize').clear();
        cy.get('#gameSize').type('123');
        cy.get('#gamePrice').clear();
        cy.get('#gamePrice').type('123');
        cy.get('#gamePlayType').clear();
        cy.get('#gamePlayType').type('123');
        cy.get('#gameDescription').clear();
        cy.get('#gameDescription').type('123');
        cy.get('#genre').select('SinglePlayer');
        cy.get('form > #createGame').click();
    })








})