package com.targetindia.model;

import lombok.Data;

public record Customer(int id, String name, String email, String phone, String city) {
    public static Customer[] getCustomers() {
        return new Customer[]{
                new Customer(192, "Ramesh", "ramesh@xmpl.com", "9292818122", "Chennai"),
                new Customer(112,"Dru Radclyffe","dradclyffe0@utexas.edu","8479217874","Bataiporã"),
                new Customer(253,"Kennan Grime","kgrime1@artisteer.com","1915078552","Cikupa"),
                new Customer(323,"Annabelle Cafferty","acafferty2@ovh.net","9861468631","Caburan"),
                new Customer(412,"Wiatt Benjamin","wbenjamin3@so-net.ne.jp","4049322706","Gafanha da Encarnação"),
                new Customer(125,"Darda Leal","dleal4@bbc.co.uk","6224816840","Nakhon Nayok"),
                new Customer(266,"Rania Presho","rpresho5@g.co","4541579592","Aţ Ţafīlah"),
                new Customer(791,"Ulysses Charters","ucharters6@umn.edu","1766857527","Bobrovka"),
                new Customer(198,"Jaime Boichat","jboichat7@tinyurl.com","8561617427","Macamic"),
                new Customer(920,"Fannie Gjerde","fgjerde8@pinterest.com","1642265131","Christiana"),
                new Customer(103,"Phillie Pickover","ppickover9@oaic.gov.au","5099917677","Orange Farm"),
                new Customer(111,"Yul Chaddock","ychaddocka@ft.com","8288265044","San Agustín Acasaguastlán"),
                new Customer(212,"Langston Weber","lweberb@slideshare.net","6468517890","Arbais"),
                new Customer(113,"Pepito Edden","peddenc@netscape.com","2216169152","Tríkala"),
                new Customer(154,"Cort McCathie","cmccathied@cafepress.com","2895607606","Deneysville"),
                new Customer(155,"Bayard Aymeric","baymerice@elpais.com","7025602781","Huacrachuco"),
                new Customer(616,"Norry Darcey","ndarceyf@sciencedirect.com","8908410369","Pulautemiang"),
                new Customer(167,"Lacy Holleworth","lholleworthg@loc.gov","4789034175","Lyubertsy"),
                new Customer(186,"Hailey McCumskay","hmccumskayh@4shared.com","2143234372","Vasylkiv"),
                new Customer(719,"Sissie McKall","smckalli@topsy.com","4611341753","Oinoússes"),
        };
    }
}
