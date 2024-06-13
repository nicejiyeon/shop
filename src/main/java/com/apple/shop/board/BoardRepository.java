package com.apple.shop.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> { //$1:테이블, $2:Id Type
}
