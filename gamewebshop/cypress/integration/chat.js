import "cypress-localstorage-commands";
describe("can use the chat functionality", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
      })
      
    it("gets the game container correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/chat"]').click();
        cy.get('#outlined-basic-email').clear();
        cy.get('#outlined-basic-email').type('Hello');
        cy.get('.MuiSvgIcon-root').click();
        cy.get('#outlined-basic-email').clear();
        cy.get('#outlined-basic-email').type('I can use the chat');
        cy.get('.MuiSvgIcon-root').click();
    })
      







})