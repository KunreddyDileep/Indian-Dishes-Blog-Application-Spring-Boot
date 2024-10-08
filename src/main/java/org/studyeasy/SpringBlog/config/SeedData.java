package org.studyeasy.SpringBlog.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.models.Authority;
import org.studyeasy.SpringBlog.models.Post;
import org.studyeasy.SpringBlog.services.AccountService;
import org.studyeasy.SpringBlog.services.AuthorityService;
import org.studyeasy.SpringBlog.services.PostService;
import org.studyeasy.SpringBlog.util.constants.Privillages;
import org.studyeasy.SpringBlog.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

       for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

       }
        
       Account account01 = new Account();
       Account account02 = new Account();
       Account account03 = new Account();
       Account account04 = new Account();

       account01.setEmail("user@user.com");
       account01.setPassword("pass987");
       account01.setFirstname("User");
       account01.setLastname("lastname");
       account01.setAge(25);
       account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account01.setGender("Male");



       account02.setEmail("dileepreddy2703@gmail.com");
       account02.setPassword("pass987");
       account02.setFirstname("Admin");
       account02.setLastname("lastname");
       account02.setRole(Roles.ADMIN.getRole());
       account02.setAge(25);
       account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account02.setGender("Female");

       account03.setEmail("editor@editor.com");
       account03.setPassword("pass987");
       account03.setFirstname("Editor");
       account03.setLastname("lastname");
       account03.setRole(Roles.EDITOR.getRole());
       account03.setAge(55);
       account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
       account03.setGender("Male");

       account04.setEmail("super_editor@editor.com");
       account04.setPassword("pass987");
       account04.setFirstname("Editor");
       account04.setLastname("lastname");
       account04.setRole(Roles.EDITOR.getRole());
       account04.setAge(40);
       account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
       account04.setGender("Female");

       
       Set<Authority> authorities = new HashSet<>();
       authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
       authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
       account04.setAuthorities(authorities);

       accountService.save(account01);
       accountService.save(account02);
       accountService.save(account03);
       accountService.save(account04);
       


       List<Post> posts = postService.findAll();
       if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Pakora");
            post01.setBody("""
               <p><a href="https://www.recipetineats.com/pakora-indian-vegetable-fritters/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347434/india-food-chicken-pakora/india-food-chicken-pakora-1120x732.jpg" alt=""></a></p>
               <p>Fretting about which fried food to try? You can’t go wrong with a pakora – a delicious, deep-fried spiced fritter.</p>

               <h3><strong>Pakora</strong></h3>
               <p>Pakora is a savory, deep-fried Indian snack made with chunks of vegetables such as potato, cauliflower and eggplant, or meat of choice, which is then dipped in chickpea flour, seasoned with turmeric, salt, chili, or other spices, and deep-fried in ghee.</p>

               <p>It is a quintessential Indian snack, easily found on numerous street corners and most popular during spring, when the locals choose to celebrate the monsoon season by eating fried foods.</p>
            """);
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Chaat");
            post02.setBody("""
               
               <p><a href="https://www.tasteofhome.com/article/chaat/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347465/india-food-aloo-chaat/india-food-aloo-chaat-1120x732.jpg" alt=""></a></p>
               <p>Chaat and chat anyone? Head for the nearest street vendor selling these snack-size mini-meals and socialize!</p>

               <h3><strong>Chaat</strong></h3>
               <p>The name chaat encompasses a wide variety of Indian street foods, snacks, or small meals which usually combine salty, spicy, sweet, and sour flavors. They are usually small, consumed on their own as a snack, or combined with other dishes to form a big meal.</p>

               <p>Throughout India, chaat can be found at chaatwallas – street vendors serving various dishes, from stuffed bread to deep-fried pastries with accompanying dipping sauces.</p>      
              
            """);
            
            post02.setAccount(account03);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("Vada Pav");
            post03.setBody("""
               
               <p><a href="https://www.indianhealthyrecipes.com/vada-pav-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347356/india-food-vada-pav/india-food-vada-pav-1120x732.jpg" alt=""></a></p>
               <p>When hungry in Mumbai, the abundant Vada Pav vendors can satiate your appetite with these burger-style beauties.</p>
               
               <h3><strong>Vada Pav</strong></h3>
               <p>Vada Pav is a favorite sandwich-style snack from Mumbai, named after its ingredients: vada, or spicy mashed potatoes, which are deep-fried in chickpea batter; and pav, or white bread rolls. This iconic street food is said to have originated from a street vendor named Ashok Vaidya, who worked near the Dadar train station in the sixties and seventies, and came up with a way to satiate the hungry workers.</p>

            """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Idli");
            post04.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/soft-idli-recipe-using-idli-rava/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347416/india-food-idli/india-food-idli-1120x732.jpg" alt=""></a></p>
               <p>Cake for breakfast anyone? Idli is a favorite savory morning staple in South India.</p>

               <h3><strong>Idli</strong></h3>
               <p>Idli is a traditional, savory Indian cake that is a popular breakfast item in many South Indian households, although it can be found throughout the country. It is made with a batter consisting of fermented lentils and rice, which is then steamed. These savory cakes are commonly served hot and consumed on their own, dipped into sambar or chutneys, or seasoned with a range of spices.</p>

            """);
            
            post04.setAccount(account04);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("Paratha");
            post05.setBody("""
               
               <p><a href="https://www.indianhealthyrecipes.com/paratha-recipe-plain-paratha/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347392/india-food-paratha/india-food-paratha-1120x732.jpg" alt=""></a></p>
               <p>Popular throughout India, paratha are perfect just on their own and often served with a whole host of accoutrements</p>

               <h3><strong>Paratha</strong></h3>
               <p>Paratha is a flaky, layered, golden-brown Indian bread, which is typically consumed for breakfast. It consists of whole wheat flour that’s baked in ghee, Indian clarified butter, and comes in round, triangular, square, or hexagonal shapes.</p>

               <p>Very often, parathas are stuffed with ingredients such as boiled potatoes, cauliflower, garlic, ginger, chili, paneer, or radish. They are sometimes accompanied by pickles, yogurt, homemade chutneys, and occasionally served as a side to meat and vegetable curries. In Punjab, paratha is eaten with lassi, a popular yogurt-based drink.</p>
            """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("Naan");
            post06.setBody("""
                      
               <p><a href="https://www.recipetineats.com/naan-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347396/india-food-naan/india-food-naan-1120x732.jpg" alt=""></a></p>
               
               <p>Leavened heaven – the favorite accompaniment of curries across the Western world, naan is mainly eaten in the Punjab region and the north of India, without the rice!</p>
               
               <h3><strong>Naan</strong></h3>
               <p>Naan is a well-liked flatbread with a chewy texture. It consists of white flour, yeast, eggs, milk, salt, and sugar, baked in a tandoor oven. Its characteristic tear-drop shape is achieved due to the way that the dough droops as it cooks on the tandoor walls.</p>

            """);
            
            post06.setAccount(account03);
            postService.save(post06);

            Post post07 = new Post();
            post07.setTitle("Aloo Gobi");
            post07.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/aloo-gobi-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347459/india-food-aloo-gobi/india-food-aloo-gobi-1120x732.jpg" alt=""></a></p>
               
               <p>If you like potatoes and cauliflower, you’re in for a treat – Aloo Gobi literally translates as potatoes & cauliflower and is a true classic.</p>

               <h3><strong>Aloo Gobi</strong></h3>
               <p>Aloo Gobi is a vegetarian dry curry, consisting of potatoes (aloo), cauliflower (gobi), and Indian spices. It has a warm, yellow-orange color because it contains turmeric. Other common ingredients include kalonji, curry leaves, garlic, ginger, onion, coriander stalks, tomato, peas, and cumin.</p>

            """);
            
            post07.setAccount(account03);
            postService.save(post07);

            Post post08 = new Post();
            post08.setTitle("Butter Chicken");
            post08.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/butter-chicken/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347444/india-food-butter-chicken/india-food-butter-chicken-1120x732.jpg" alt=""></a></p>
               
               <p>Butter? Nom. Chicken? Nom. Butter chicken? Non nom nom nom.</p>

               <h3><strong>Butter Chicken</strong></h3>
               <p>A dish of tender chicken in a mildly spiced tomato sauce. It’s traditionally cooked in a tandoor (a cylindrical clay oven). The gravy is always made first by boiling down fresh tomato, garlic, and cardamom into a bright red pulp. This pulp is then pureed after cooling. Butter, various spices, and khoa (dried whole milk) is then added. The dish originated in Delhi during the 1950s.</p>

            """);
            
            post08.setAccount(account03);
            postService.save(post08);

            Post post09 = new Post();
            post09.setTitle("Dal Tadka");
            post09.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/dal-tadka/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347425/india-food-dal-tadka/india-food-dal-tadka-1120x732.jpg" alt=""></a></p>
               
               <p>It’s all in the tadka process – the flavored oil tempering brings out all the spices’ health benefits and add piquancy to this divinely delicious dal dish.</p>

               <h3><strong>Dal Tadka</strong></h3>
               <p>This classic lentil-based dish originates from the northern parts of India. Although there are variations, the dish is usually prepared with toor dal (split yellow peas), garlic, ginger, onions, tomatoes, garam masala, red chili peppers, ghee, cumin, coriander, turmeric, and fenugreek leaves. Once prepared, dal tadka is usually garnished with coriander leaves and served hot with jeera rice and roti on the side.</p>

            """);
            
            post09.setAccount(account04);
            postService.save(post09);

            Post post10 = new Post();
            post10.setTitle("Masala Dosa");
            post10.setBody("""
            
               <p><a href="https://www.indianhealthyrecipes.com/masala-dosa-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347401/india-food-masala-dosa/india-food-masala-dosa-1120x732.jpg" alt=""></a></p>
               
               <p>Masala dosa are sumptuous savory snacks not too dissimilar in appearance to crêpes.</p>

               <h3><strong>Masala Dosa</strong></h3>
               <p>The traditional southern Indian dish known as masala dosa is popular throughout the country, made from a batter of soaked rice and black lentils, which are ground into a paste and blended to create a thick batter, usually left to ferment overnight. The mixture is enriched with a handful of fenugreek seeds, which gives the dosa its distinctive golden-brown color and a delicious, crispy texture.</p>

               <p>It is then baked on a hot oiled griddle into a thin pancake and often stuffed with potatoes, onions, and mustard seeds before being garnished with grated coconut and chopped coriander. It is usually consumed as a quick snack, but can also be a breakfast dish.</p>
            """);
            
            post10.setAccount(account01);
            postService.save(post10);

            Post post11 = new Post();
            post11.setTitle("Sambar");
            post11.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/andhra-sambar-recipe-how-to-make-south-indian-sambar/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347374/india-food-sambar/india-food-sambar-1120x732.jpg" alt=""></a></p>
               
               <p>The stupendous stew of Tamil Nadu state, the Sambar is now popular across South India and has even been adapted into Myanamr’s Burmese cuisine.</p>

               <h3><strong>Sambar</strong></h3>
               <p>Sambar is a tamarind-based broth, prepared with lentils and vegetables. It originates from Tamil Nadu, but it is also very popular throughout South India. The dish is traditionally served with steamed rice or various Indian flatbreads.</p>
            """);
            
            post11.setAccount(account03);
            postService.save(post11);

            Post post12 = new Post();
            post12.setTitle("Shahi Paneer (Mughalai Paneer)");
            post12.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/shahi-paneer-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347365/india-food-shahi-paneer/india-food-shahi-paneer-1120x732.jpg" alt=""></a></p>
               
               <p>One of the most popular delicacies of Mughlai cuisine, shahi paneer was popular with Mughal emperor royalty (from where it gets its name – “Shahi” means royal in Urdu), and its creamy richness most apt! The dish is still popular in northern parts of India and neighboring countries.</p>

               <h3><strong>Shahi Paneer (Mughalai Paneer)</strong></h3>
               <p>Originating from India’s Mughlai cuisine, shahi paneer is a rich, hearty and nutritious cheese curry, prepared with paneer cheese, onions, almond paste, and a rich, spicy tomato-cream sauce. The dish is typically accompanied by Indian breads such as naan, roti, or puri, and garnished with coriander leaves.</p>
            """);
            
            post12.setAccount(account01);
            postService.save(post12);

            Post post13 = new Post();
            post13.setTitle("Tandoori Chicken");
            post13.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/tandoori-chicken-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347361/india-food-tandoori-chicken/india-food-tandoori-chicken-1120x732.jpg" alt=""></a></p>
               
               <p>With origins dating back some 5000 years, but named after the tandoor clay ovens found in the Punjab it is cooked in, tandoori chicken is a healthy, meaty masterpiece of a meal.</p>

               <h3><strong>Tandoori Chicken</strong></h3>
               <p>Tandoori chicken is one of the most famous Indian dishes. It is made by marinating chicken meat in yogurt, and is seasoned with tandoori masala, nutmeg, and cumin, before being placed on skewers. Traditionally, it is cooked at very high temperatures in cylindrical clay ovens called tandoor, resulting in succulent meat with a smokey flavor.</p>
            """);
            
            post13.setAccount(account04);
            postService.save(post13);

            Post post14 = new Post();
            post14.setTitle("Malabar Fish Curry");
            post14.setBody("""
                      
               <p><a href="https://www.yummytummyaarthi.com/malabar-fish-curry-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347405/india-food-malabar-fish-curry/india-food-malabar-fish-curry-1120x732.jpg" alt=""></a></p>
               
               <p>Malabar curry is a south Indian dish particularly associated with the Keralan region, where the coastlines, climate and cultural history make spicy fish curries popular.</p>

               <h3><strong>Malabar Fish Curry</strong></h3>
               <p>This authentic fish curry originates from Malabar, Kerala. The curry is typically made with seer, sea bass, tilapia, or sardines. Other ingredients include onions, tomatoes, hot chili peppers, chili powder, curry leaves, coriander, turmeric, garlic, fenugreek, tamarind, oil, and coconut milk, which lends the dish its rich creaminess. It is flavored with deep and earthy Indian spices such as fried curry leaves and tamarind.</p>
            """);
            
            post14.setAccount(account04);
            postService.save(post14);

            Post post15 = new Post();
            post15.setTitle("Biryani");
            post15.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/chicken-biryani-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347449/india-food-biriyani/india-food-biriyani-1120x732.jpg" alt=""></a></p>
               
               <p>Spice up your life with spiced-up rice – the brilliant and bright biriyani is one of the most well-known Indian-Pakistani dishes on Indian menus.</p>

               <h3><strong>Biryani</strong></h3>
               <p>Biriyani dates back to the Mughal Empire. The main ingredients are basmati rice, spices, a base of meat, eggs, or vegetables, and many optional ingredients such as dried fruits, nuts, and yogurt. It is believed that Mumtaz Mahal – Emperor Shah Jahan’s queen for whom the Taj Mahal was built as a tomb for – inspired the dish in the 1600s.</p>
            """);
            
            post15.setAccount(account01);
            postService.save(post15);

            Post post16 = new Post();
            post16.setTitle("Samosa");
            post16.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/samosa-recipe-make-samosa/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347369/india-food-samosa/india-food-samosa-1120x732.jpg" alt=""></a></p>
               
               <p>Originally named Samsa, the samosa – India’s favorite street food – has medieval Middle Eastern origins, its name deriving from the Persian word sanbosag, for “triangular pastry”.</p>

               <h3><strong>Samosa</strong></h3>
               <p>Samosas are a tasty, deep fried, or baked, golden brown pastry triangles with savory fillings, usually spiced potatoes, onions, peas, and lentils, although sometimes, they are made with ground lamb, ground beef or ground chicken. Samosas are typically served hot and accompanied with chopped onions, yogurt, or fresh, homemade Indian chutneys and sauces made with a variety of ingredients such as mint, coriander or tamarind.</p>

               <p>These puffy treats are common Indian street food and are believed to have traveled to India along the old trade routes from Central Asia.</p>
            """);
            
            post16.setAccount(account03);
            postService.save(post16);

            Post post17 = new Post();
            post17.setTitle("Ras Malai");
            post17.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/rasmalai-recipe-easy-rasmalai-in-10-mins-diwali-recipes/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347382/india-food-ras-malai/india-food-ras-malai-1120x732.jpg" alt=""></a></p>
               
               <p>Rarely maligned, ras malai is simply too delicious for food critics to say a bad word about this sweet-smelling (and tasting!) spongy treat.</p>

               <h3><strong>Ras Malai</strong></h3>
               <p>Ras Malai is a much-loved, delicious Indian dessert of West Bengali origin made from white cream, sugar, milk, and cardamom-flavored paneer cheese known as chhana. Cashews, almonds and saffron are often added. Spongy, soft, and aromatic, it is typically served chilled and garnished with cardamom seeds or dried fruits. It is commonly consumed during festivals such as Holi and Diwali.</p>

            """);
            
            post17.setAccount(account01);
            postService.save(post17);

            Post post18 = new Post();
            post18.setTitle("Kulfi");
            post18.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/kulfi-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347413/india-food-kulfi/india-food-kulfi-1120x732.jpg" alt=""></a></p>
               
               <p>Ice-cream lolly-style. Holla a kulfiwallah (Kulfi street vendor) and try out this delicious, unmissable dessert.</p>

               <h3><strong>Kulfi</strong></h3>
               <p>Kulfi is a classic Indian ice cream made with slowly simmered whole milk. Although the long-simmering process results in a loss of volume, it makes up for it with a delicious, nutty, caramelized flavor. The ice cream is characterized by its unusual, conical shape, a result of using traditional, special molds with tight-fitting lids.</p>

               <p>Kulfi is usually flavored with ingredients such as pistachio, rose water, green tea, and saffron. It is believed to have been invented by the early inhabitants of the Himalayas during the Mughal Empire era.</p>
            """);
            
            post18.setAccount(account04);
            postService.save(post18);

            Post post19 = new Post();
            post19.setTitle("Gulab Jamun");
            post19.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/gulab-jamun-recipe-using-milk-powder/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347420/india-food-gulab-jamun/india-food-gulab-jamun-1120x732.jpg" alt=""></a></p>
               
               <p>Sticky and sweet, Gulab Jamun is the national dessert of India.</p>

               <h3><strong>Gulab Jamun</strong></h3>
               <p>Gulab jamun is a dessert based on milk solids that are kneaded into a dough, shaped into balls, and deep-fried in ghee. The balls then get soaked in a sweet thick syrup, flavored with saffron, green cardamom, and rose water. When served, gulab jamun is often garnished with dried nuts to further enhance its flavors.</p>

            """);
            
            post19.setAccount(account03);
            postService.save(post19);

            Post post20 = new Post();
            post20.setTitle("Barfi");
            post20.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/milk-powder-burfi/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347454/india-food-barfi/india-food-barfi-1120x732.jpg" alt=""></a></p>
               
               <p>No they don’t make you want to barf – barfi actually originate from the Hindustani word for snow. These pista barfi are flavored with ground pistachios.</p>

               <h3><strong>Barfi</strong></h3>
               <p>Even though its name originates from Persia, barfi is an original Indian sweet that resembles a fudge. It is made from a base of condensed milk solids (khoa or khoya), granulated sugar, and ghee, and the most common ingredients added to this include nuts, usually pistachios, cashews, and peanuts. However, fruits, saffron, rose water, gram flour, or almonds are also found in some regional varieties.</p>

            """);
            
            post20.setAccount(account03);
            postService.save(post20);

            Post post21 = new Post();
            post21.setTitle("Lassi");
            post21.setBody("""
                      
               <p><a href="https://www.indianhealthyrecipes.com/lassi-recipe/"><img src="https://res.cloudinary.com/rainforest-cruises/images/c_fill,g_auto/f_auto,q_auto/w_1120,h_732,c_fill,g_auto/v1661347409/india-food-lassi/india-food-lassi-1120x732.jpg" alt=""></a></p>
               
               <p>Last but not least, lassi are as dependable as Lassie when it comes to quenching your thirst and satisfying your desire for dessert.</p>

               <h3><strong>Lassi</strong></h3>
               <p>Traditionally served in a handle-less clay cup called a kulhar, lassi is a frothy yogurt-based drink, blended with water and various fruits or seasonings. It originated in Punjab and there are many varieties, but most are either sweet or salted. Mmm mango lassi. That thought alone makes us want to go to India!</p>

            """);
            
            post21.setAccount(account01);
            postService.save(post21);

       }
        
    }
    
}
