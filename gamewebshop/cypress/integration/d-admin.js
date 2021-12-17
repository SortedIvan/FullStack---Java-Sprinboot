import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    beforeEach(() => {
        cy.login("ivantest", "12345");
        cy.saveLocalStorage();
      })

      beforeEach(() => {
        cy.restoreLocalStorage();
      });
      
    it("can load the game table succesfully", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/mygames"]').click();
    })

    it("see the system Requirements and get the game", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/games"]').click();
        cy.get(':nth-child(1) > #gamecontainer > .MuiCardActions-root > #systemRequirements').click();
        cy.get(':nth-child(1) > #gamecontainer > .MuiCardActions-root > #getGame').click();
    })


})


// cy.get('.datatable').find('tr').should('have.length', 4)