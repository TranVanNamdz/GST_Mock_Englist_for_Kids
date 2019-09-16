package com.example.gst_mock_englist_for_kids.utils;

import android.content.Context;


import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;

import java.util.ArrayList;
import java.util.List;


public final class DataForDatabase {

    private final Context mContext;

    private Database mDatabase;

    public DataForDatabase(Context mContext) {

        this.mContext = mContext;
    }

    public void addDataTopicTable() {
        final List<Topic> list = new ArrayList<>();
        list.add(new Topic(1, "Bảng chữ cái", "img_topic/alphabet.png"));
        list.add(new Topic(2, "Số đếm", "img_topic/number.png"));
        list.add(new Topic(3, "Động vật", "img_topic/animal.png"));
        list.add(new Topic(4, "Giáng sinh", "img_topic/christmas.png"));
        list.add(new Topic(5, "Màu sắc", "img_topic/color.png"));
        list.add(new Topic(6, "Đồ ăn", "img_topic/food.png"));
        list.add(new Topic(7, "Hoa quả", "img_topic/fruit.png"));
        list.add(new Topic(8, "Bông Hoa", "img_topic/flower.png"));
        list.add(new Topic(9, "Hình học", "img_topic/geometry.png"));
        list.add(new Topic(10, "Nhà cửa", "img_topic/house.png"));
        list.add(new Topic(11, "Quốc gia", "img_topic/nation.png"));
        list.add(new Topic(12, "Trường học", "img_topic/school.png"));
        list.add(new Topic(13, "Xe cộ", "img_topic/vehicle.png"));
        list.add(new Topic(14, "Đồ uống", "img_topic/water.png"));

        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertTopic(list);
            }
        });

    }

    public void addDataTopicDetailsTable() {
        final List<TopicDetails> listDetailTopic = new ArrayList<>();

        /* add data for Alphabet
         *
         **/
        listDetailTopic.add(new TopicDetails(1, "img_alphabet/a.png", "A", 1));
        listDetailTopic.add(new TopicDetails(2, "img_alphabet/b.png", "B", 1));
        listDetailTopic.add(new TopicDetails(3, "img_alphabet/c.png", "C", 1));
        listDetailTopic.add(new TopicDetails(4, "img_alphabet/d.png", "D", 1));
        listDetailTopic.add(new TopicDetails(5, "img_alphabet/e.png", "E", 1));
        listDetailTopic.add(new TopicDetails(6, "img_alphabet/f.png", "F", 1));
        listDetailTopic.add(new TopicDetails(7, "img_alphabet/g.png", "G", 1));
        listDetailTopic.add(new TopicDetails(8, "img_alphabet/h.png", "H", 1));
        listDetailTopic.add(new TopicDetails(9, "img_alphabet/i.png", "I", 1));
        listDetailTopic.add(new TopicDetails(10, "img_alphabet/j.png", "J", 1));
        listDetailTopic.add(new TopicDetails(11, "img_alphabet/k.png", "K", 1));
        listDetailTopic.add(new TopicDetails(12, "img_alphabet/l.png", "L", 1));
        listDetailTopic.add(new TopicDetails(13, "img_alphabet/m.png", "M", 1));
        listDetailTopic.add(new TopicDetails(14, "img_alphabet/n.png", "N", 1));
        listDetailTopic.add(new TopicDetails(15, "img_alphabet/o.png", "O", 1));
        listDetailTopic.add(new TopicDetails(16, "img_alphabet/p.png", "P", 1));
        listDetailTopic.add(new TopicDetails(17, "img_alphabet/q.png", "Q", 1));
        listDetailTopic.add(new TopicDetails(18, "img_alphabet/r.png", "R", 1));
        listDetailTopic.add(new TopicDetails(19, "img_alphabet/s.png", "S", 1));
        listDetailTopic.add(new TopicDetails(20, "img_alphabet/t.png", "T", 1));
        listDetailTopic.add(new TopicDetails(21, "img_alphabet/u.png", "U", 1));
        listDetailTopic.add(new TopicDetails(22, "img_alphabet/v.png", "V", 1));
        listDetailTopic.add(new TopicDetails(23, "img_alphabet/w.png", "W", 1));
        listDetailTopic.add(new TopicDetails(24, "img_alphabet/x.png", "X", 1));
        listDetailTopic.add(new TopicDetails(25, "img_alphabet/y.png", "Y", 1));
        listDetailTopic.add(new TopicDetails(26, "img_alphabet/z.png", "Z", 1));

        /*
         * add data for Number
         *
         **/
        listDetailTopic.add(new TopicDetails(27, "img_number/start.png", "", 2));
        listDetailTopic.add(new TopicDetails(28, "img_number/one.png", "One", 2));
        listDetailTopic.add(new TopicDetails(29, "img_number/two.png", "Two", 2));
        listDetailTopic.add(new TopicDetails(30, "img_number/three.png", "Three", 2));
        listDetailTopic.add(new TopicDetails(31, "img_number/four.png", "Four", 2));
        listDetailTopic.add(new TopicDetails(32, "img_number/five.png", "Five", 2));
        listDetailTopic.add(new TopicDetails(33, "img_number/six.png", "Six", 2));
        listDetailTopic.add(new TopicDetails(34, "img_number/seven.png", "Seven", 2));
        listDetailTopic.add(new TopicDetails(35, "img_number/eight.png", "Eight", 2));
        listDetailTopic.add(new TopicDetails(36, "img_number/nine.png", "Nine", 2));
        listDetailTopic.add(new TopicDetails(37, "img_number/ten.png", "Ten", 2));
        listDetailTopic.add(new TopicDetails(38, "img_number/eleven.png", "Eleven", 2));
        listDetailTopic.add(new TopicDetails(39, "img_number/twelve.png", "Twelve", 2));
        listDetailTopic.add(new TopicDetails(40, "img_number/thirteen.png", "Thirteen", 2));
        listDetailTopic.add(new TopicDetails(41, "img_number/fourteen.png", "Fourteen", 2));
        listDetailTopic.add(new TopicDetails(42, "img_number/fifteen.png", "Fifteen", 2));
        listDetailTopic.add(new TopicDetails(43, "img_number/sixteen.png", "Sixteen", 2));
        listDetailTopic.add(new TopicDetails(44, "img_number/seventeen.png", "Seventeen", 2));
        listDetailTopic.add(new TopicDetails(45, "img_number/eighteen.png", "Eighteen", 2));
        listDetailTopic.add(new TopicDetails(46, "img_number/nineteen.png", "Nineteen", 2));
        listDetailTopic.add(new TopicDetails(47, "img_number/twenty.png", "Twenty", 2));

        /*
         * add Data for animal
         * **/
        listDetailTopic.add(new TopicDetails(48, "img_animal/bear.png", "Bear", 3));
        listDetailTopic.add(new TopicDetails(49, "img_animal/elephant.png", "Elephant", 3));
        listDetailTopic.add(new TopicDetails(50, "img_animal/hippo.png", "Hippo", 3));
        listDetailTopic.add(new TopicDetails(51, "img_animal/leopard.png", "Leopard", 3));
        listDetailTopic.add(new TopicDetails(52, "img_animal/lion.png", "Lion", 3));
        listDetailTopic.add(new TopicDetails(53, "img_animal/mouse.png", "Mouse", 3));
        listDetailTopic.add(new TopicDetails(54, "img_animal/tiger.png", "Tiger", 3));
        listDetailTopic.add(new TopicDetails(55, "img_animal/eagle.png", "Eagle", 3));
        listDetailTopic.add(new TopicDetails(56, "img_animal/parrot.png", "Parrot", 3));
        listDetailTopic.add(new TopicDetails(57, "img_animal/dog.png", "Dog", 3));
        listDetailTopic.add(new TopicDetails(58, "img_animal/cat.png", "Cat", 3));
        listDetailTopic.add(new TopicDetails(59, "img_animal/chicken.png", "Chicken", 3));
        listDetailTopic.add(new TopicDetails(60, "img_animal/pig.png", "Pig", 3));
        listDetailTopic.add(new TopicDetails(61, "img_animal/cow.png", "Cow", 3));
        listDetailTopic.add(new TopicDetails(62, "img_animal/butterfly.png", "Butterfly", 3));


        //add data color
        listDetailTopic.add(new TopicDetails(63, "img_color/black.png", "Black", 5));
        listDetailTopic.add(new TopicDetails(64, "img_color/blue.png", "Blue", 5));
        listDetailTopic.add(new TopicDetails(65, "img_color/brown.png", "Brown", 5));
        listDetailTopic.add(new TopicDetails(66, "img_color/green.png", "Green", 5));
        listDetailTopic.add(new TopicDetails(67, "img_color/red.png", "Red", 5));
        listDetailTopic.add(new TopicDetails(68, "img_color/violet.png", "Violet", 5));
        listDetailTopic.add(new TopicDetails(69, "img_color/white.png", "White", 5));
        listDetailTopic.add(new TopicDetails(70, "img_color/yellow.png", "Yellow", 5));

        //add data for christmas
        listDetailTopic.add(new TopicDetails(71, "img_christmas/angle.png", "Angle", 4));
        listDetailTopic.add(new TopicDetails(72, "img_christmas/christmas_tree.png", "Christmas tree", 4));
        listDetailTopic.add(new TopicDetails(73, "img_christmas/father_christmas.png", "Father christmas", 4));
        listDetailTopic.add(new TopicDetails(74, "img_christmas/mistletoe.png", "Mistletoe", 4));
        listDetailTopic.add(new TopicDetails(75, "img_christmas/sleigh.png", "Sleigh", 4));
        listDetailTopic.add(new TopicDetails(76, "img_christmas/snowman.png", "Snowman", 4));

        //add data for food
        listDetailTopic.add(new TopicDetails(77, "img_food/beef.png", "Beef", 6));
        listDetailTopic.add(new TopicDetails(78, "img_food/bread.png", "Bread", 6));
        listDetailTopic.add(new TopicDetails(79, "img_food/cheese.png", "Cheese", 6));
        listDetailTopic.add(new TopicDetails(80, "img_food/egg.png", "Egg", 6));
        listDetailTopic.add(new TopicDetails(81, "img_food/hotpot.png", "Hotpot", 6));
        listDetailTopic.add(new TopicDetails(82, "img_food/pizza.png", "Pizza", 6));
        listDetailTopic.add(new TopicDetails(83, "img_food/rice.png", "Rice", 6));
        listDetailTopic.add(new TopicDetails(84, "img_food/soup.png", "Soup", 6));


        // add data of flower

        listDetailTopic.add(new TopicDetails(85, "img_flower/rose.png", "Rose", 8));
        listDetailTopic.add(new TopicDetails(86, "img_flower/aster.png", "Aster", 8));
        listDetailTopic.add(new TopicDetails(87, "img_flower/carnation.png", "Carnation", 8));
        listDetailTopic.add(new TopicDetails(88, "img_flower/chrysanthemum.png", "Chrysanthemum", 8));
        listDetailTopic.add(new TopicDetails(89, "img_flower/daffodil.png", "Daffodil", 8));
        listDetailTopic.add(new TopicDetails(90, "img_flower/flax.png", "Flax", 8));
        listDetailTopic.add(new TopicDetails(91, "img_flower/hibiscus.png", "Hibiscus", 8));
        listDetailTopic.add(new TopicDetails(92, "img_flower/lotus.png", "Lotus", 8));
        listDetailTopic.add(new TopicDetails(93, "img_flower/orchid.png", "Orchid", 8));
        listDetailTopic.add(new TopicDetails(94, "img_flower/poppy_flower.png", "Poppy flower", 8));
        listDetailTopic.add(new TopicDetails(95, "img_flower/sun_flower.png", "Sun Flower", 8));
        listDetailTopic.add(new TopicDetails(96, "img_flower/tulip.png", "Tulip", 8));

        // add data for fruit

        listDetailTopic.add(new TopicDetails(97, "img_fruit/apple.png", "Apple", 7));
        listDetailTopic.add(new TopicDetails(98, "img_fruit/orange.png", "Orange", 7));
        listDetailTopic.add(new TopicDetails(99, "img_fruit/jack_fruit.png", "Jack Fruit", 7));
        listDetailTopic.add(new TopicDetails(100, "img_fruit/coconut.png", "Coconut", 7));
        listDetailTopic.add(new TopicDetails(101, "img_fruit/kiwi.png", "Kiwi", 7));
        listDetailTopic.add(new TopicDetails(102, "img_fruit/cucumber.png", "Cucumber", 7));
        listDetailTopic.add(new TopicDetails(103, "img_fruit/mangoes.png", "Mangoes", 7));
        listDetailTopic.add(new TopicDetails(104, "img_fruit/strawberries.png", "Strawberry", 7));
        listDetailTopic.add(new TopicDetails(105, "img_fruit/watermelon.png", "Watermelon", 7));
        listDetailTopic.add(new TopicDetails(106, "img_fruit/eggplant.png", "Eggplant", 7));
        listDetailTopic.add(new TopicDetails(107, "img_fruit/lemon.png", "Lemon", 7));
        listDetailTopic.add(new TopicDetails(108, "img_fruit/banana.png", "Banana", 7));
        listDetailTopic.add(new TopicDetails(109, "img_fruit/pear.png", "Pear", 7));
        listDetailTopic.add(new TopicDetails(110, "img_fruit/grapes.png", "Grapes", 7));
        listDetailTopic.add(new TopicDetails(111, "img_fruit/cherry.png", "Cherry", 7));
        listDetailTopic.add(new TopicDetails(112, "img_fruit/pineapple.png", "Pineapple", 7));
        listDetailTopic.add(new TopicDetails(113, "img_fruit/guava.png", "Guava", 7));
        listDetailTopic.add(new TopicDetails(114, "img_fruit/plums.png", "Plums", 7));

        // add data for geometry
        listDetailTopic.add(new TopicDetails(115, "img_geometry/circle.png", "Circle", 9));
        listDetailTopic.add(new TopicDetails(116, "img_geometry/cross.png", "Cross", 9));
        listDetailTopic.add(new TopicDetails(117, "img_geometry/diamond.png", "Diamond", 9));
        listDetailTopic.add(new TopicDetails(118, "img_geometry/hexagon.png", "Hexagon", 9));
        listDetailTopic.add(new TopicDetails(119, "img_geometry/heart.png", "Heart", 9));
        listDetailTopic.add(new TopicDetails(120, "img_geometry/pentagon.png", "Pentagon", 9));
        listDetailTopic.add(new TopicDetails(121, "img_geometry/pyramid.png", "Pyramid", 9));
        listDetailTopic.add(new TopicDetails(122, "img_geometry/star.png", "Star", 9));
        listDetailTopic.add(new TopicDetails(123, "img_geometry/rectangle.png", "Rectangle", 9));
        listDetailTopic.add(new TopicDetails(124, "img_geometry/square.png", "Square", 9));
        listDetailTopic.add(new TopicDetails(125, "img_geometry/trapezoid.png", "Trapezoid", 9));
        listDetailTopic.add(new TopicDetails(126, "img_geometry/triangle.png", "Triangle", 9));

        // add data for house
        listDetailTopic.add(new TopicDetails(127, "img_house/bed.png", "Bed", 10));
        listDetailTopic.add(new TopicDetails(128, "img_house/bookcase.png", "Bookcase", 10));
        listDetailTopic.add(new TopicDetails(129, "img_house/chair.png", "Chair", 10));
        listDetailTopic.add(new TopicDetails(130, "img_house/table.png", "Table", 10));
        listDetailTopic.add(new TopicDetails(131, "img_house/clock.png", "Clock", 10));
        listDetailTopic.add(new TopicDetails(132, "img_house/chopping_board.png", "Chopping Board", 10));
        listDetailTopic.add(new TopicDetails(133, "img_house/fridge.png", "Fridge", 10));
        listDetailTopic.add(new TopicDetails(134, "img_house/knife.png", "Knife", 10));
        listDetailTopic.add(new TopicDetails(135, "img_house/phone.png", "Phone", 10));
        listDetailTopic.add(new TopicDetails(136, "img_house/picture.png", "Picture", 10));
        listDetailTopic.add(new TopicDetails(137, "img_house/sofa.png", "Sofa", 10));
        listDetailTopic.add(new TopicDetails(138, "img_house/television.png", "Television", 10));

        // add data for school
        listDetailTopic.add(new TopicDetails(139, "img_school/board.png", "Board", 12));
        listDetailTopic.add(new TopicDetails(140, "img_school/book.png", "Book", 12));
        listDetailTopic.add(new TopicDetails(141, "img_school/calendar.png", "Calendar", 12));
        listDetailTopic.add(new TopicDetails(142, "img_school/teacher.png", "Teacher", 12));
        listDetailTopic.add(new TopicDetails(143, "img_school/eraser.png", "Eraser", 12));
        listDetailTopic.add(new TopicDetails(144, "img_school/crayon.png", "Crayon", 12));
        listDetailTopic.add(new TopicDetails(145, "img_school/map.png", "Map", 12));
        listDetailTopic.add(new TopicDetails(146, "img_school/notebook.png", "Notebook", 12));
        listDetailTopic.add(new TopicDetails(147, "img_school/globe.png", "Globe", 12));
        listDetailTopic.add(new TopicDetails(148, "img_school/ruler.png", "Ruler", 12));
        listDetailTopic.add(new TopicDetails(149, "img_school/schoolbag.png", "Schoolbag", 12));
        listDetailTopic.add(new TopicDetails(150, "img_school/pencil.png", "Pencil", 12));

        //add data for vehicle
        listDetailTopic.add(new TopicDetails(151, "img_vehicle/airplane.png", "Airplane", 13));
        listDetailTopic.add(new TopicDetails(152, "img_vehicle/bike.png", "Bike", 13));
        listDetailTopic.add(new TopicDetails(153, "img_vehicle/bus.png", "Bus", 13));
        listDetailTopic.add(new TopicDetails(154, "img_vehicle/car.png", "Car", 13));
        listDetailTopic.add(new TopicDetails(155, "img_vehicle/motorbike.png", "Motorbike", 13));
        listDetailTopic.add(new TopicDetails(156, "img_vehicle/ship.png", "Ship", 13));
        listDetailTopic.add(new TopicDetails(157, "img_vehicle/train.png", "Train", 13));
        listDetailTopic.add(new TopicDetails(158, "img_vehicle/excavator.png", "Excavator", 13));
        listDetailTopic.add(new TopicDetails(159, "img_vehicle/truck.png", "Truck", 13));
        listDetailTopic.add(new TopicDetails(160, "img_vehicle/honda_cbr_1000.png", "Honda CBR 1000", 13));
        listDetailTopic.add(new TopicDetails(161, "img_vehicle/roll_royce.png", "Roll Royce", 13));
        listDetailTopic.add(new TopicDetails(162, "img_vehicle/kawasaki_ninja_h2r.png", "Kawasaki Ninja H2R", 13));

        // add data for nation
        listDetailTopic.add(new TopicDetails(163, "img_nation/argentina.png", "Argentina", 11));
        listDetailTopic.add(new TopicDetails(164, "img_nation/brazil.png", "Brazil", 11));
        listDetailTopic.add(new TopicDetails(165, "img_nation/vietnam.png", "Vietnam", 11));
        listDetailTopic.add(new TopicDetails(166, "img_nation/china.png", "China", 11));
        listDetailTopic.add(new TopicDetails(167, "img_nation/england.png", "England", 11));
        listDetailTopic.add(new TopicDetails(168, "img_nation/germany.png", "Germany", 11));
        listDetailTopic.add(new TopicDetails(169, "img_nation/italian.png", "Italian", 11));
        listDetailTopic.add(new TopicDetails(170, "img_nation/usa.png", "American", 11));
        listDetailTopic.add(new TopicDetails(171, "img_nation/japan.png", "Japan", 11));
        listDetailTopic.add(new TopicDetails(172, "img_nation/mexico.png", "Mexico", 11));
        listDetailTopic.add(new TopicDetails(173, "img_nation/thailand.png", "Thailand", 11));
        listDetailTopic.add(new TopicDetails(174, "img_nation/south_africa.png", "South Africa", 11));



        // add data for water

        listDetailTopic.add(new TopicDetails(175, "img_water/alcohol.png", "Alcohol", 14));
        listDetailTopic.add(new TopicDetails(176, "img_water/beer.png", "Beer", 14));
        listDetailTopic.add(new TopicDetails(177, "img_water/chivas.png", "Chivas", 14));
        listDetailTopic.add(new TopicDetails(178, "img_water/coca_cola.png", "Coca-Cola", 14));
        listDetailTopic.add(new TopicDetails(179, "img_water/coffee.png", "Coffee", 14));
        listDetailTopic.add(new TopicDetails(180, "img_water/ding_tea.png", "Ding-Tea", 14));
        listDetailTopic.add(new TopicDetails(181, "img_water/milk_tea.png", "Milk-Tea", 14));
        listDetailTopic.add(new TopicDetails(182, "img_water/pepsi.png", "Pepsi", 14));
        listDetailTopic.add(new TopicDetails(183, "img_water/red_bull.png", "Red Bull", 14));
        listDetailTopic.add(new TopicDetails(184, "img_water/smoothie.png", "Smoothie", 14));
        listDetailTopic.add(new TopicDetails(185, "img_water/tea.png", "Tea", 14));
        listDetailTopic.add(new TopicDetails(186, "img_water/strongbow.png", "Strongbow", 14));

        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertTopicDetails(listDetailTopic);
            }
        });

    }
}
