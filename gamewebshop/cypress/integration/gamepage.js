import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
      })
      
    it("gets the game container correctly", ()=>{
        cy.visit("/games")


    })
      


})