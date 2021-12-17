import "cypress-localstorage-commands";
describe("renders the about us page", () =>{

    beforeEach(() => {
        cy.login("boriz1","12345");
        cy.saveLocalStorage();
      });
    
      beforeEach(() => {
        cy.restoreLocalStorage();
      });
      
    it("renders correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get("#container").should("exist")
    })

    it("allows the button to be clicked", ()=>{
        cy.visit("/AboutUs")
        cy.get('#gamesbutton').click();
    })
})